package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.ClinicDentist;
import com.example.demo.service.ClinicDentistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/clinicDentist")
public class ClinicDentistController {
	private final ClinicDentistService clinicDentistService;

    public ClinicDentistController(ClinicDentistService clinicDentistService) {
        this.clinicDentistService = clinicDentistService;
    }


    @GetMapping("/list")
	public ResponseEntity<?> getList(){
		try {
            List<ClinicDentist> clinicDentists = clinicDentistService.getList();
            return new ResponseEntity<>(new ClinicDentistListResponse(clinicDentists), HttpStatus.OK);
		}
		catch (RuntimeException e){
			return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		try {
			ClinicDentist clinicDentist = clinicDentistService.getById(id);
			return new ResponseEntity<>(new ClinicDentistByIdResponse(clinicDentist), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/dentist/{dentistId}")
	public ResponseEntity<?> getByDentistId(@PathVariable Integer dentistId) {
		try {
			List<ClinicDentist> clinicDentists = clinicDentistService.getByDentistId(dentistId);
			return new ResponseEntity<>(new ClinicDentistByDentistIdResponse(clinicDentists), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("{clinicId}")
	public ResponseEntity<?> getByClinicId(@PathVariable Integer clinicId) {
		try {
			List<ClinicDentist> clinicDentists = clinicDentistService.getByClinicId(clinicId);
			return new ResponseEntity<>(new ClinicDentistByClinicIdResponse(clinicDentists), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("{timeslotId}")
	public ResponseEntity<?> getByTimeslotId(@PathVariable Integer timeslotId) {
		try {
			List<ClinicDentist> clinicDentists = clinicDentistService.getByTimeslotId(timeslotId);
			return new ResponseEntity<>(new ClinicDentistByTimeslotIdResponse(clinicDentists), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}


}