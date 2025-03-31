package com.SEHS4701.group.service;

import com.SEHS4701.group.dto.DentistByIdResponse;
import com.SEHS4701.group.dto.DentistListResponse;

public interface DentistService {

	DentistListResponse getList();

	DentistByIdResponse getById(Integer id);
}