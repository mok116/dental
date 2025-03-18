package com.example.demo.service;

import com.example.demo.model.Patient;

public interface PatientService {

	Patient registerPatient(Patient patient);

	Patient login(String email, String password);

	Patient getById(Integer id);
}