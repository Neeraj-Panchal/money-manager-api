package com.money.moneymanager.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileDto {

    private Long id;
    private String fullName;
    private String email;
    private String profileImageUrl;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
