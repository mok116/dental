package com.example.demo.dto;

import com.example.demo.model.DayOfWeek;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ClinicDentistByIdResponse extends BaseResponse {
    private ClinicDentist clinicDentist;

    public ClinicDentistByIdResponse(ClinicDentist clinicDentist) {
        this.clinicDentist = clinicDentist;
    }

    @Getter
    @Setter
    public static class ClinicDentist{
        private Integer id;
        private Integer clinicId;
        private Integer dentistId;
        private DayOfWeek dayOfWeek;
        private String timeslotId;
    }
}
