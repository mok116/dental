package com.example.demo.dto;

import com.example.demo.model.AppointmentItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class AppointmentItemByPatientIdResponse extends BaseResponse {
    private List<AppointmentItem> appointmentItems;

    public AppointmentItemByPatientIdResponse(List<AppointmentItem> appointmentItems) {
        this.appointmentItems = appointmentItems;
    }
}
