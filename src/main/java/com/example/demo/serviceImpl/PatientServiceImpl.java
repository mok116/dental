package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
	public Patient registerPatient(Patient patient) {
        if (patientRepository.findByEmailAddress(patient.getEmailAddress()) != null) {
            throw new RuntimeException("Email already registered!");
        }
        return patientRepository.save(patient);
    }

    @Override
	public Patient login(String email, String password) {
        Patient patient = patientRepository.findByEmailAddress(email);
        if (patient != null && patient.getPassword().equals(password)) {
            return patient;
        }
        return null;
    }
}