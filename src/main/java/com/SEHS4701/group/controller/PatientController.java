package com.SEHS4701.group.controller;

import com.SEHS4701.group.dto.*;
import com.SEHS4701.group.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(patientService.getById(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest registerRequest) {
        try {
            int lastInsertId = patientService.registerPatient(registerRequest);
            return new ResponseEntity<>(new RegisterResponse(lastInsertId), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            return new ResponseEntity<>(patientService.login(loginRequest.getEmailAddress(), loginRequest.getPassword()), HttpStatus.OK);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/edit")
    public  ResponseEntity<?> edit(@Valid @RequestBody EditRequest editRequest) {
        try{
            patientService.edit(editRequest);
            return new ResponseEntity<>(new BaseResponse(), HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordRequest forgotPasswordRequest) {
        try {
            patientService.sendPasswordResetEmail(forgotPasswordRequest.getEmail());
            return new ResponseEntity<>(new BaseResponse(0, "Password reset email sent successfully"), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
        try {
            patientService.resetPassword(
                resetPasswordRequest.getEmail(),
                resetPasswordRequest.getCode(),
                resetPasswordRequest.getNewPassword()
            );
            return new ResponseEntity<>(new BaseResponse(0, "Password reset successfully"), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}