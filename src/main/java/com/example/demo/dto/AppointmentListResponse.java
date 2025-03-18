package com.example.demo.dto;

import com.example.demo.model.Appointment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class AppointmentListResponse extends BaseResponse {
    private List<Appointment> appointments;

    public AppointmentListResponse(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
