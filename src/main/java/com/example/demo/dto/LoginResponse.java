package com.example.demo.dto;

import com.example.demo.model.Patient;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LoginResponse extends BaseResponse {
    private Patient patient;

    public LoginResponse(Patient patient) {
        this.patient = patient;
    }
}
