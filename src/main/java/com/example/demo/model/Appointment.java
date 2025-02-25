package com.example.demo.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Patient patient;
	@ManyToOne
	private Dentist dentist;
	@ManyToOne
	private Clinic clinic;
	private LocalDateTime appointmentTime;
	private String status; // e.g., "Confirmed", "Cancelled"
}