package com.example.demo.controller;

import com.example.demo.dto.*;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;

import java.time.LocalDate;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;
    private final ModelMapper modelMapper;

    @Autowired
    public PatientController(PatientService patientService, ModelMapper modelMapper) {
        this.patientService = patientService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@RequestParam int id) {
        try {
            Patient patient = patientService.getById(id);
            return new ResponseEntity<>(new PatientByIdResponse(patient), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest registerRequest) {
        try {
            Patient patient = modelMapper.map(registerRequest, Patient.class);
            patient.setCreatedAt(LocalDate.now());
            patient.setLastLoginAt(LocalDate.now());
            Patient registeredPatient = patientService.registerPatient(patient);
            return new ResponseEntity<>(new BaseResponse(), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Patient patient = patientService.login(loginRequest.getEmail(), loginRequest.getPassword());
        try {
            return new ResponseEntity<>(new LoginResponse(patient), HttpStatus.OK);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}