package com.example.demo.service;

import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.PatientByIdResponse;
import com.example.demo.dto.RegisterRequest;

public interface PatientService {

	void registerPatient(RegisterRequest registerRequest);

	LoginResponse login(String email, String password);

	PatientByIdResponse getById(Integer id);
}