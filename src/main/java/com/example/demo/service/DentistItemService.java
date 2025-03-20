package com.example.demo.service;

import com.example.demo.dto.DentistItemByDentistIdResponse;
import com.example.demo.dto.DentistItemByIdResponse;
import com.example.demo.dto.DentistItemListResponse;

public interface DentistItemService {

	DentistItemListResponse getList();

	DentistItemByIdResponse getById(Integer id);

	DentistItemByDentistIdResponse getByDentistId(Integer id);
}