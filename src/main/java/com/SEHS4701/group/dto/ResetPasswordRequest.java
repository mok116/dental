package com.SEHS4701.group.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPasswordRequest {
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Code is required")
    private String code;

    @NotBlank(message = "New password is required")
    private String newPassword;
}