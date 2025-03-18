package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientService;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient registerPatient(Patient patient) {
        Optional<Patient> registeredPatient = patientRepository.findByEmailAddress(patient.getEmailAddress());
        if (registeredPatient.isEmpty()) {
            throw new RuntimeException("Email already registered!");
        }
        return patientRepository.save(patient);
    }

    @Override
    public Patient login(String email, String password) {
        Optional<Patient> loginedPatient = patientRepository.findByEmailAddress(email);
        if (loginedPatient.isEmpty() || loginedPatient.get().getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials!");
        }
        return loginedPatient.get();
    }

    @Override
    public Patient getById(Integer id) {
            Optional<Patient> patientById = patientRepository.findById(id);
        if (patientById.isEmpty()) {
            throw new RuntimeException("patient not found!");
        }
        return patientById.get();
    }
}