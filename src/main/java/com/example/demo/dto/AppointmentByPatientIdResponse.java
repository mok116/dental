package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
public class AppointmentByPatientIdResponse extends BaseResponse {
    private List<Appointment> appointments;

    public AppointmentByPatientIdResponse(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Getter
    @Setter
    public static class Appointment{
            private int id;
            private int patientId;
            private int clinicDentistId;
            private LocalDateTime appointmentDate;
            private String totalAmount;
            private String status;
            private LocalDateTime createdAt;
    }
}
