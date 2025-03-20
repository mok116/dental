package com.example.demo.service;

import com.example.demo.dto.*;

public interface ClinicDentistService {

	ClinicDentistListResponse getList();


	ClinicDentistByIdResponse getById(Integer id);

	ClinicDentistByClinicIdResponse getByClinicId(Integer clinicId);

	ClinicDentistByDentistIdResponse getByDentistId(Integer dentistId);

	ClinicDentistByTimeslotIdResponse getByTimeslotId(Integer timeslotId);
}