package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

	@GetMapping("/")
	public String welcome(Model model) {
		model.addAttribute("message", "Welcome to my Spring Boot application!");
		return "welcome"; // Refers to welcome.html template
	}
/*
	@GetMapping("/greet")
	public String showGreetForm() {
	    return "greet"; // Refers to greet.html template
	}

	@PostMapping("/greet")
	public String greetSubmit(@RequestParam String name, Model model) {
	    model.addAttribute("greeting", "Hello, " + name + "!");
	    return "greeting"; // Refers to greeting.html template
	}
	*/
}