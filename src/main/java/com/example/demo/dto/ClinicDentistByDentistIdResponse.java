package com.example.demo.dto;

import com.example.demo.model.DayOfWeek;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ClinicDentistByDentistIdResponse extends BaseResponse {
    private List<ClinicDentist> clinicDentist;

    public ClinicDentistByDentistIdResponse(List<ClinicDentist> clinicDentist) {
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
