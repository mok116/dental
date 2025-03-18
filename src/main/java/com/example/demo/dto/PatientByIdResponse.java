package com.example.demo.dto;

import com.example.demo.model.Patient;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PatientByIdResponse extends BaseResponse {
    private Patient patient;

    public PatientByIdResponse(Patient patient) {
        this.patient = patient;
    }

    public PatientByIdResponse(int code, Patient patient) {
        super(code);
        this.patient = patient;
    }

    public PatientByIdResponse(int code, String message, Patient patient) {
        super(code, message);
        this.patient = patient;
    }
}
