package com.quickserve.auth.service.impl;

import com.quickserve.auth.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    public void sendOtpEmail(String toEmail, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("QuickServe - Email Verification OTP");
        message.setText("Your OTP for QuickServe registration is: " + otp +
                "\n\nThis OTP is valid for 10 minutes.");

        mailSender.send(message);
    }
}
