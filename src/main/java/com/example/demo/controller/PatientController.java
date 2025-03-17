package com.example.demo.controller;

import com.example.demo.dto.BaseResponse;
import com.example.demo.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

//    @GetMapping("/register")
//    public String showRegisterForm(Model model) {
//        model.addAttribute("patient", new Patient());
//        return "register";
//    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Patient patient) {
        try {
            Patient registeredPatient = patientService.registerPatient(patient);
            return new ResponseEntity<>(new BaseResponse(HttpStatus.CREATED.value()), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new BaseResponse(HttpStatus.CREATED.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam LoginRequest loginRequest) {
        Patient patient = patientService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (patient != null) {
            return new ResponseEntity<>(patient, HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
    }

}