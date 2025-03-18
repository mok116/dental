package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AppointmentItemCreateRequest extends BaseResponse {
    @NotNull(message = "Appointment Item ID cannot be null")
    @Positive(message = "Appointment Item ID must be a positive number")
    private Integer appointmentItemId;

    @NotNull(message = "Appointment ID cannot be null")
    @Positive(message = "Appointment ID must be a positive number")
    private Integer appointmentId;
}
