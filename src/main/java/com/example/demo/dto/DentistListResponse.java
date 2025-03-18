package com.example.demo.dto;

import com.example.demo.model.Dentist;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class DentistListResponse extends BaseResponse {
    private List<Dentist> dentistList;

    public DentistListResponse(List<Dentist> dentistList) {
        this.dentistList = dentistList;
    }
}
