package com.SEHS4701.group.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RegisterRequest {
    @NotNull(message = "First name is required")
    private String firstName;

    @NotNull(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Email address is required")
    private String emailAddress;

    @NotNull(message = "Password is required")
    private String password;

    @NotNull(message = "Phone is required")
    private String phone;

    @NotNull(message = "Gender is required")
    @Pattern(regexp = "^[MF]$", message = "Gender must be 'M' or 'F'")
    private String gender;

    @NotNull(message = "Date of birth is required")
    private LocalDateTime dob;
}