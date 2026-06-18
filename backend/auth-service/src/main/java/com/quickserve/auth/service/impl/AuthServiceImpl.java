package com.quickserve.auth.service.impl;

import com.quickserve.auth.dto.*;
import com.quickserve.auth.eintity.OtpToken;
import com.quickserve.auth.eintity.Role;
import com.quickserve.auth.eintity.User;
import com.quickserve.auth.eintity.enums.OtpType;
import com.quickserve.auth.eintity.enums.RoleName;
import com.quickserve.auth.repository.OtpTokenRepository;
import com.quickserve.auth.repository.RoleRepository;
import com.quickserve.auth.repository.UserRepository;
import com.quickserve.auth.service.AuthService;
import com.quickserve.auth.service.EmailService;
import com.quickserve.auth.util.JwtUtil;
import com.quickserve.auth.util.OtpGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final OtpGenerator otpGenerator;
    private final OtpTokenRepository otpTokenRepository;
    private final EmailService emailService;
    private final JwtUtil jwtUtil;

    @Override
    public RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO) {

        if (userRepository.existsByEmail(registerRequestDTO.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        if (!registerRequestDTO.getPassword().equals(registerRequestDTO.getConfirmPassword())) {
            throw new RuntimeException("Password and Confirm Password do not match");
        }

        RoleName roleName = RoleName.valueOf(registerRequestDTO.getRole().toUpperCase());

        Role role = roleRepository.findByRoleName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));

        String encryptedPassword = passwordEncoder.encode(registerRequestDTO.getPassword());

        User user = User.builder()
                .fullName(registerRequestDTO.getFullName())
                .email(registerRequestDTO.getEmail())
                .password(encryptedPassword)
                .role(role)
                .isVerified(false)
                .isActive(true)
                .build();

        User savedUser = userRepository.save(user);

        String otp = otpGenerator.generateOpt();

        OtpToken otpToken = OtpToken.builder()
                .email(savedUser.getEmail())
                .otp(otp)
                .type(OtpType.REGISTRATION)
                .isUsed(false)
                .expiresAt(LocalDateTime.now().plusMinutes(10))
                .build();

        otpTokenRepository.save(otpToken);

        emailService.sendOtpEmail(savedUser.getEmail(), otp);

        return RegisterResponseDTO.builder()
                .userId(savedUser.getUserId())
                .fullName(savedUser.getFullName())
                .email(savedUser.getEmail())
                .role(savedUser.getRole().getRoleName().toString())
                .message("Registration successful. OTP sent to your email.")
                .build();
    }

    @Override
    public VerifyOtpResponseDTO verifyOtp(VerifyOtpRequestDTO verifyOtpRequestDTO) {

        OtpToken otpToken = otpTokenRepository
                .findByEmailAndOtp(verifyOtpRequestDTO.getEmail(), verifyOtpRequestDTO.getOtp())
                .orElseThrow(() -> new RuntimeException("Invalid OTP"));

        if (otpToken.getIsUsed()) {
            throw new RuntimeException("OTP already used");
        }

        if (otpToken.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("OTP expired");
        }

        User user = userRepository.findByEmail(verifyOtpRequestDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setIsVerified(true);
        userRepository.save(user);

        otpToken.setIsUsed(true);
        otpTokenRepository.save(otpToken);

        return VerifyOtpResponseDTO.builder()
                .email(user.getEmail())
                .isVerified(true)
                .message("Email verified successfully")
                .build();
    }

    @Override
    public ResendOtpResponseDTO resendOtp(ResendOtpRequestDTO resendOtpRequestDTO) {

        User user = userRepository.findByEmail(resendOtpRequestDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getIsVerified()) {
            throw new RuntimeException("Email already verified");
        }

        String otp = otpGenerator.generateOpt();

        OtpToken otpToken = OtpToken.builder()
                .email(user.getEmail())
                .otp(otp)
                .type(OtpType.REGISTRATION)
                .isUsed(false)
                .expiresAt(LocalDateTime.now().plusMinutes(10))
                .build();

        otpTokenRepository.save(otpToken);

        emailService.sendOtpEmail(user.getEmail(), otp);

        return ResendOtpResponseDTO.builder()
                .email(user.getEmail())
                .message("New OTP sent to your email.")
                .build();
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {

        User user = userRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!user.getIsActive()) {
            throw new RuntimeException("Account is deactivated");
        }

        if (!user.getIsVerified()) {
            throw new RuntimeException("Please verify your email first");
        }

        if (!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.genereateToken(
                user.getEmail(),
                user.getUserId(),
                user.getRole().getRoleName().toString()
        );

        return LoginResponseDTO.builder()
                .userId(user.getUserId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .role(user.getRole().getRoleName().toString())
                .token(token)
                .build();
    }


}
