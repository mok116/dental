package com.example.demo.controller;

import com.example.demo.dto.AppointmentByPatientIdResponse;
import com.example.demo.dto.AppointmentCreateRequest;
import com.example.demo.dto.AppointmentListResponse;
import com.example.demo.dto.BaseResponse;
import com.example.demo.model.Appointment;
import com.example.demo.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/create")
	public ResponseEntity<?> createAppointment(@RequestBody AppointmentCreateRequest appointmentCreateRequest) {
		try {
			Appointment appointment = modelMapper.map(appointmentCreateRequest, Appointment.class);
			appointment.setCreatedAt(LocalTime.now());
			appointmentService.createAppointment(appointment);
			return new ResponseEntity<>(new BaseResponse(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/patient/{patientId}")
	public ResponseEntity<?> getPatientAppointments(@PathVariable("patientId") Integer patientId) {
		try {
			List<Appointment> appointments = appointmentService.getAppointmentsByPatient(patientId);
		return new ResponseEntity<>(new AppointmentByPatientIdResponse(appointments), HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(new BaseResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<?> getPatientAppointments() {
		try {
			List<Appointment> appointments = appointmentService.getAll();
			return new ResponseEntity<>(new AppointmentListResponse(appointments), HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(new BaseResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}


}