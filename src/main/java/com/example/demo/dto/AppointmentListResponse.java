package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;


@Getter
@Setter
public class AppointmentListResponse extends BaseResponse {
    private List<Appointment> appointments;

    public AppointmentListResponse(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Getter
    @Setter
    public static class Appointment{
        private int id;
        private int patientId;
        private int clinicDentistId;
        private LocalTime appointmentDate;
        private String totalAmount;
        private String status;
        private LocalTime createdAt;
    }
}
