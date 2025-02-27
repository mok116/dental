package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.ClinicRepository;
import com.example.demo.repository.DentistRepository;
import com.example.demo.repository.ScheduleRepository;

@Controller
public class ClinicController {
    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private DentistRepository dentistRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping("/clinics")
    public String showClinicInfo(Model model) {
        model.addAttribute("clinics", clinicRepository.findAll());
        model.addAttribute("dentists", dentistRepository.findAll());
        model.addAttribute("schedules", scheduleRepository.findAll());
        return "clinics";
    }
}	