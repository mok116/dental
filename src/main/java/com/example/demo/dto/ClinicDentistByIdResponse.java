package com.example.demo.dto;

import com.example.demo.model.ClinicDentist;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ClinicDentistByIdResponse extends BaseResponse {
    private ClinicDentist clinicDentist;

    public ClinicDentistByIdResponse(ClinicDentist clinicDentist) {
        this.clinicDentist = clinicDentist;
    }
}
