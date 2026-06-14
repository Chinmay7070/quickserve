package com.quickserve.auth.service;

import com.quickserve.auth.dto.*;

public interface AuthService {

    RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO);
    VerifyOtpResponseDTO verifyOtp(VerifyOtpRequestDTO verifyOtpRequestDTO);
    ResendOtpResponseDTO resendOtp(ResendOtpRequestDTO resendOtpRequestDTO);
}
