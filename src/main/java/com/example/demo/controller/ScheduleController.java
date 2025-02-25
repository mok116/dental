package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

@Controller
public class ScheduleController {
	@Autowired
	private PatientRepository patientRepository;

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("patient", new Patient());
		return "register";
	}

	@PostMapping("/register")
	public String registerPatient(@ModelAttribute Patient patient) {
		patientRepository.save(patient);
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}
}