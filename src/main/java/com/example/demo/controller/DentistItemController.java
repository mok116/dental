package com.example.demo.controller;

import com.example.demo.dto.BaseResponse;
import com.example.demo.dto.DentistItemByIdResponse;
import com.example.demo.dto.DentistItemListResponse;
import com.example.demo.model.DentistItem;
import com.example.demo.service.DentistItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/dentistItem")
public class DentistItemController {
	private final DentistItemService dentistItemService;

    public DentistItemController(DentistItemService dentistItemService) {
        this.dentistItemService = dentistItemService;
    }


    @GetMapping("/list")
	public ResponseEntity<?> getList(){
		try {
            List<DentistItem> dentistItems = dentistItemService.getList();
            return new ResponseEntity<>(new DentistItemListResponse(dentistItems), HttpStatus.OK);
		}
		catch (RuntimeException e){
			return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getById(@RequestParam Integer id) {
		try {
			DentistItem dentistItem = dentistItemService.getById(id);
			return new ResponseEntity<>(new DentistItemByIdResponse(dentistItem), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/dentist/{id}")
	public ResponseEntity<?> getByDentistId(@RequestParam Integer id) {
		try {
			DentistItem dentistItem = dentistItemService.getById(id);
			return new ResponseEntity<>(new DentistItemByIdResponse(dentistItem), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(new BaseResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}




}