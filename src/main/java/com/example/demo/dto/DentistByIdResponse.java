package com.example.demo.dto;

import com.example.demo.model.Dentist;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DentistByIdResponse extends BaseResponse {
    private Dentist dentist;

    public DentistByIdResponse(Dentist dentist) {
        this.dentist = dentist;
    }
}
