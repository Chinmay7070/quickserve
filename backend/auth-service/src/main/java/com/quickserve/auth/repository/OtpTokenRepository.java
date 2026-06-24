package com.quickserve.auth.repository;

import com.quickserve.auth.eintity.OtpToken;
import com.quickserve.auth.eintity.enums.OtpType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpTokenRepository extends JpaRepository<OtpToken , Long> {

    Optional<OtpToken> findByEmailAndOtp(String email, String otp);
    Optional<OtpToken> findByEmailAndOtpAndType(String email, String otp, OtpType type);

}
