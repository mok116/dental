package com.SEHS4701.group.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentCancelRequest extends BaseResponse {
    @NotNull(message = "Appointment ID is required")
    private Integer appointmentId;

    // Getters and Setters
    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }
}