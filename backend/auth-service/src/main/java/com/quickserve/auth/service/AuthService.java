package com.quickserve.auth.service;

import com.quickserve.auth.dto.RegisterRequestDTO;
import com.quickserve.auth.dto.RegisterResponseDTO;
import com.quickserve.auth.dto.VerifyOtpRequestDTO;
import com.quickserve.auth.dto.VerifyOtpResponseDTO;

public interface AuthService {

    RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO);
    VerifyOtpResponseDTO verifyOtp(VerifyOtpRequestDTO verifyOtpRequestDTO);
}
