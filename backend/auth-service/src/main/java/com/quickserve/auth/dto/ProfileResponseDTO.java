package com.quickserve.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileResponseDTO {

    private Long userId;

    private String fullName;

    private String email;

    private String role;

    private Boolean isVerified;

    private Boolean isActive;

    private LocalDateTime createdAt;
}