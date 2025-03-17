package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Appointment;
import com.example.demo.model.Patient;
import com.example.demo.repository.ClinicRepository;
import com.example.demo.repository.DentistRepository;
import com.example.demo.service.BookingService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private DentistRepository dentistRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @GetMapping
    public String showBookingForm(Model model, HttpSession session) {
        Patient patient = (Patient) session.getAttribute("patient");
        if (patient == null) {
            return "redirect:/patient/login";
        }
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("dentists", dentistRepository.findAll());
        model.addAttribute("clinics", clinicRepository.findAll());
        return "booking";
    }

//    @PostMapping
//    public String bookAppointment(@ModelAttribute Appointment appointment,
//                                  HttpSession session, Model model) {
//        Patient patient = (Patient) session.getAttribute("patient");
//        if (patient == null) {
//            return "redirect:/patient/login";
//        }
//        appointment.setPatient(patient);
//        String error = bookingService.bookAppointment(appointment);
//        if (error != null) {
//            model.addAttribute("error", error);
//            model.addAttribute("dentists", dentistRepository.findAll());
//            model.addAttribute("clinics", clinicRepository.findAll());
//            return "booking";
//        }
//        return "success";
//    }

//    @GetMapping("/enquiry")
//    public String showBookingEnquiry(Model model, HttpSession session) {
//        Patient patient = (Patient) session.getAttribute("patient");
//        if (patient == null) {
//            return "redirect:/patient/login";
//        }
//        model.addAttribute("appointments", bookingService.getPatientAppointments(patient.getId()));
//        return "enquiry";
//    }
}