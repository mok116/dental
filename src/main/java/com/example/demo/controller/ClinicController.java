package com.example.demo.controller;

import com.example.demo.dto.BaseResponse;
import com.example.demo.service.ClinicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clinic")
public class ClinicController {

    private final ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getClinicById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(clinicService.getById(id), HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(new BaseResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> getClinicList(){
        try {
            return new ResponseEntity<>(clinicService.getList(), HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(new BaseResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}