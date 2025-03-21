package com.SEHS4701.group.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class AppointmentCreateRequest extends BaseResponse {
    @NotNull(message = "Patient ID cannot be null")
    @Positive(message = "Patient ID must be a positive number")
    private Integer patientId;

    @NotNull(message = "Clinic Dentist ID cannot be null")
    @Positive(message = "Clinic Dentist ID must be a positive number")
    private Integer clinicDentistId;

    @NotNull(message = "Appointment date cannot be null")
    @FutureOrPresent(message = "Appointment date must be in the present or future")
    private LocalDateTime appointmentDate;

    @NotNull(message = "Total amount cannot be null")
    @PositiveOrZero(message = "Total amount must be zero or positive")
    private Integer totalAmount;

    @NotBlank(message = "Status cannot be blank")
    @Pattern(regexp = "PENDING|CONFIRMED|CANCELLED|COMPLETED", message = "Status must be one of: PENDING, CONFIRMED, CANCELLED, COMPLETED")
    private String status;
}
