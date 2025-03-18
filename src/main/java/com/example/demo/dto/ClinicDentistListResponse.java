package com.example.demo.dto;

import com.example.demo.model.ClinicDentist;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ClinicDentistListResponse extends BaseResponse {
    private List<ClinicDentist> CLinicDentistList;

    public ClinicDentistListResponse(List<ClinicDentist> CLinicDentistList) {
        this.CLinicDentistList = CLinicDentistList;
    }
}
