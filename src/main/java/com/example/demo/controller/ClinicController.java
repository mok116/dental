package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.ClinicRepository;
import com.example.demo.repository.DentistRepository;

@Controller
public class ClinicController {
    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private DentistRepository dentistRepository;

}	