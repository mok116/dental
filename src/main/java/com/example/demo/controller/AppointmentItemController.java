package com.example.demo.controller;

import com.example.demo.dto.AppointmentItemByPatientIdResponse;
import com.example.demo.dto.BaseResponse;
import com.example.demo.model.AppointmentItem;
import com.example.demo.service.AppointmentItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/appointmentItem")
public class AppointmentItemController {
	@Autowired
	private AppointmentItemService appointmentItemService;
	@Autowired
	private ModelMapper modelMapper;

//	@PostMapping("/create")
//	public ResponseEntity<?> createAppointmentItem(@RequestBody AppointmentItemCreateRequest appointmentItemCreateRequest) {
//		try {
//			appointmentItemService.save(appointment);
//			return new ResponseEntity<>(new BaseResponse(), HttpStatus.OK);
//		}catch(Exception e) {
//			return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
//		}
//	}

	@GetMapping("/appointment/{appointmentItemId}")
	public ResponseEntity<?> getPatientAppointments(@PathVariable("appointmentItemId") Integer appointmentItemId) {
		try {
			List<AppointmentItem> appointmentItems = appointmentItemService.getByAppointmentId(appointmentItemId);
		return new ResponseEntity<>(new AppointmentItemByPatientIdResponse(appointmentItems), HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(new BaseResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}

//	@GetMapping("/list")
//	public ResponseEntity<?> getPatientAppointments() {
//		try {
//			List<Appointment> appointments = appointmentRepository.findAll();
//			return new ResponseEntity<>(new AppointmentListResponse(appointments), HttpStatus.OK);
//		}catch(RuntimeException e) {
//			return new ResponseEntity<>(new BaseResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
//		}
//	}


}