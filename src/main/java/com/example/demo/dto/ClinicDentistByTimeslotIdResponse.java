package com.example.demo.dto;

import com.example.demo.model.ClinicDentist;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ClinicDentistByTimeslotIdResponse extends BaseResponse {
    private List<ClinicDentist> clinicDentist;

    public ClinicDentistByTimeslotIdResponse(List<ClinicDentist> clinicDentist) {
        this.clinicDentist = clinicDentist;
    }
}
