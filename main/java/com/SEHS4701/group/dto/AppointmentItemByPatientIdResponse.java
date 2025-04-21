package com.SEHS4701.group.dto;

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

    @Getter
    @Setter
    public static class AppointmentItem{
        private int id;
        private String startTime;
        private String endTime;
        private int appointmentId;
        private int dentistItemId;
    }
}
