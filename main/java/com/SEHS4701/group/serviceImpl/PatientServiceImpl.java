package com.SEHS4701.group.serviceImpl;

import com.SEHS4701.group.dto.EditRequest;
import com.SEHS4701.group.dto.LoginResponse;
import com.SEHS4701.group.dto.PatientByIdResponse;
import com.SEHS4701.group.dto.RegisterRequest;
import com.SEHS4701.group.model.Patient;
import com.SEHS4701.group.repository.PatientRepository;
import com.SEHS4701.group.security.JwtUtil;
import com.SEHS4701.group.service.PatientService;
import jakarta.persistence.EntityManager;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final EntityManager entityManager;

    public PatientServiceImpl(PatientRepository patientRepository, ModelMapper modelMapper, JwtUtil jwtUtil, PasswordEncoder passwordEncoder, EntityManager entityManager) {
        this.patientRepository = patientRepository;
        this.modelMapper = modelMapper;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.entityManager = entityManager;
    }

    @Override
    public int registerPatient(RegisterRequest registerRequest) {
        Optional<Patient> registeredPatient = patientRepository.findByEmailAddress(registerRequest.getEmailAddress());
        if (registeredPatient.isPresent() && registeredPatient.get().getEmailAddress().equals(registerRequest.getEmailAddress())) {
            throw new RuntimeException("Email already registered!");
        }
        Patient patient = modelMapper.map(registerRequest, Patient.class);
        patient.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        patient.setCreatedAt(LocalDateTime.now());
        // patient.setLastLoginAt(LocalDateTime.now());
        Patient savedPatient = patientRepository.save(patient);
        return savedPatient.getId();
    }

    @Override
    public LoginResponse login(String email, String password) {

        Optional<Patient> loginPatientOpt = patientRepository.findByEmailAddress(email);
        if (loginPatientOpt.isEmpty()
                || !passwordEncoder.matches(password, loginPatientOpt.get().getPassword())
        ) {
            throw new RuntimeException("Invalid credentials!");
        }
        
        Patient loginPatient = loginPatientOpt.get();
        loginPatient.setLastLoginAt(LocalDateTime.now());
        patientRepository.save(loginPatient);

        LoginResponse.Patient patient = modelMapper.map(loginPatient, LoginResponse.Patient.class);
        String token = jwtUtil.generateToken(email);
        return new LoginResponse(0, token, patient);
    }

    @Override
    public PatientByIdResponse getById(Integer id) {
            Patient patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found!"));
        return new PatientByIdResponse(modelMapper.map(patient, PatientByIdResponse.Patient.class));
    }

    @Override
    public void edit(EditRequest editRequest) {
        Patient existingPatient = patientRepository.findById(editRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        modelMapper.map(editRequest, existingPatient);
        patientRepository.save(existingPatient);
    }
}