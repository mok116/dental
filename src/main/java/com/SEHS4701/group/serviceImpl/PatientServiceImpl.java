package com.SEHS4701.group.serviceImpl;

import com.SEHS4701.group.dto.LoginResponse;
import com.SEHS4701.group.dto.PatientByIdResponse;
import com.SEHS4701.group.dto.RegisterRequest;
import com.SEHS4701.group.model.Patient;
import com.SEHS4701.group.repository.PatientRepository;
import com.SEHS4701.group.security.JwtUtil;
import com.SEHS4701.group.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;
    private final JwtUtil jwtUtil;

    public PatientServiceImpl(PatientRepository patientRepository, ModelMapper modelMapper, JwtUtil jwtUtil) {
        this.patientRepository = patientRepository;
        this.modelMapper = modelMapper;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void registerPatient(RegisterRequest registerRequest) {
        Optional<Patient> registeredPatient = patientRepository.findByEmailAddress(registerRequest.getEmailAddress());
        if (registeredPatient.isPresent() && registeredPatient.get().getEmailAddress().equals(registerRequest.getEmailAddress())) {
            throw new RuntimeException("Email already registered!");
        }
        Patient patient = modelMapper.map(registerRequest, Patient.class);
        patient.setCreatedAt(LocalDateTime.now());
        patient.setLastLoginAt(LocalDateTime.now());
        patientRepository.save(patient);
    }

    @Override
    public LoginResponse login(String email, String password) {

        Optional<Patient> loginPatient = patientRepository.findByEmailAddress(email);
        if (loginPatient.isEmpty()
                || !loginPatient.get().getPassword().equals(password)
        ) {
            throw new RuntimeException("Invalid credentials!");
        }
        LoginResponse.Patient patient = modelMapper.map(loginPatient, LoginResponse.Patient.class);
        String token = jwtUtil.generateToken(email);
        return new LoginResponse(0, token, patient);
    }

    @Override
    public PatientByIdResponse getById(Integer id) {
            Patient patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found!"));
        return new PatientByIdResponse(modelMapper.map(patient, PatientByIdResponse.Patient.class));
    }
}