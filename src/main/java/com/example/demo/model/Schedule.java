package com.example.demo.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Dentist dentist;
	@ManyToOne
	private Clinic clinic;
	private String dayOfWeek; // e.g., "Monday"
	private String startTime; // e.g., "09:00"
	private String endTime; // e.g., "12:00"
}