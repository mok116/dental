package com.example.demo.controller;

import com.example.demo.dto.BaseResponse;
import com.example.demo.dto.DentistByIdResponse;
import com.example.demo.dto.DentistListResponse;
import com.example.demo.model.Dentist;
import com.example.demo.service.DentistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
			List<Dentist> dentists = dentistService.getList();
			return new ResponseEntity<>(new DentistListResponse(dentists), HttpStatus.OK);
		}
		catch (RuntimeException e){
			return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getById(@RequestParam Integer id) {
		try {
			Dentist dentist = dentistService.getById(id);
			return new ResponseEntity<>(new DentistByIdResponse(dentist), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}


}