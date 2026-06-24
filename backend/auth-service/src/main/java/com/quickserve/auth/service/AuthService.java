package com.quickserve.auth.service;

import com.quickserve.auth.dto.*;

public interface AuthService {

    RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO);
    VerifyOtpResponseDTO verifyOtp(VerifyOtpRequestDTO verifyOtpRequestDTO);
    ResendOtpResponseDTO resendOtp(ResendOtpRequestDTO resendOtpRequestDTO);
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
    ForgotPasswordResponseDTO forgotPassword(ForgotPasswordRequestDTO forgotPasswordRequestDTO);

    VerifyForgotOtpResponseDTO verifyForgotOtp(VerifyForgotOtpRequestDTO verifyForgotOtpRequestDTO);
    ResetPasswordResponseDTO resetPassword(ResetPasswordRequestDTO resetPasswordRequestDTO);
    ProfileResponseDTO getProfile(String token);
}
