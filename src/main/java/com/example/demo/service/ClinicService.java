package com.example.demo.service;

import com.example.demo.dto.ClinicByIdResponse;
import com.example.demo.dto.ClinicListResponse;

public interface ClinicService {

	ClinicListResponse getList();

	ClinicByIdResponse getById(Integer id);
}