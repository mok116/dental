package com.example.demo.controller;

import com.example.demo.dto.BaseResponse;
import com.example.demo.service.DentistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
=======

import java.util.List;
>>>>>>> c58b4bb09772f431dd327a9cdfa6cc5bc05b6289

@Controller
@RequestMapping("/dentist")
public class DentistController {
	private final DentistService dentistService;

    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }


    @GetMapping("/list")
	public ResponseEntity<?> getList(){
		try {
			return new ResponseEntity<>(dentistService.getList(), HttpStatus.OK);
		}
		catch (RuntimeException e){
			return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

<<<<<<< HEAD
//	@GetMapping("/{id}")
//	public ResponseEntity<?> getById(@PathVariable Integer id) {
//		try {
//			Dentist dentist = dentistService.getById(id);
//			return new ResponseEntity<>(new DentistByIdResponse(dentist), HttpStatus.OK);
//		} catch (RuntimeException e) {
//			return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
//		}
//	}
=======
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		try {
			Dentist dentist = dentistService.getById(id);
			return new ResponseEntity<>(new DentistByIdResponse(dentist), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
>>>>>>> c58b4bb09772f431dd327a9cdfa6cc5bc05b6289


}