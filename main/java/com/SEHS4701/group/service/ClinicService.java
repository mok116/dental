package com.SEHS4701.group.service;

import com.SEHS4701.group.dto.ClinicByIdResponse;
import com.SEHS4701.group.dto.ClinicListResponse;

public interface ClinicService {

	ClinicListResponse getList();

	ClinicByIdResponse getById(Integer id);
}