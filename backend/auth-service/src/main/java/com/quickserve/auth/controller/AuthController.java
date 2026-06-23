package com.quickserve.auth.controller;

import com.quickserve.auth.dto.*;
import com.quickserve.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@Valid @RequestBody RegisterRequestDTO registerRequestDTO) {
        RegisterResponseDTO result = authService.register(registerRequestDTO);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<VerifyOtpResponseDTO> verifyOtp(@Valid @RequestBody VerifyOtpRequestDTO verifyOtpRequestDTO) {
        VerifyOtpResponseDTO result = authService.verifyOtp(verifyOtpRequestDTO);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/resend-otp")
    public ResponseEntity<ResendOtpResponseDTO> resendOtp(@Valid @RequestBody ResendOtpRequestDTO resendOtpRequestDTO){
        ResendOtpResponseDTO result = authService.resendOtp(resendOtpRequestDTO);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO result = authService.login(loginRequestDTO);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<ForgotPasswordResponseDTO> forgotPassword(@Valid @RequestBody ForgotPasswordRequestDTO forgotPasswordRequestDTO) {
        ForgotPasswordResponseDTO result = authService.forgotPassword(forgotPasswordRequestDTO);
        return ResponseEntity.ok(result);
    }
}