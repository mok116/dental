package com.example.demo.dto;

import com.example.demo.model.ClinicDentist;
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
}
