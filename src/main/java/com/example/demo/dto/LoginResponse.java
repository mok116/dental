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

    public LoginResponse(int code, Patient patient) {
        super(code);
        this.patient = patient;
    }

    public LoginResponse(int code, String message, Patient patient) {
        super(code, message);
        this.patient = patient;
    }
}
