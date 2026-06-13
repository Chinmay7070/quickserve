package com.quickserve.auth.controller;

import com.quickserve.auth.dto.RegisterRequestDTO;
import com.quickserve.auth.dto.RegisterResponseDTO;
import com.quickserve.auth.dto.VerifyOtpRequestDTO;
import com.quickserve.auth.dto.VerifyOtpResponseDTO;
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
}