package com.SEHS4701.group.service;

import com.SEHS4701.group.dto.*;

public interface ClinicDentistService {

	ClinicDentistListResponse getList();

	ClinicDentistByIdResponse getById(Integer id);

	ClinicDentistByClinicIdResponse getByClinicId(Integer clinicId);

	ClinicDentistByDentistIdResponse getByDentistId(Integer dentistId);

	ClinicDentistByTimeslotIdResponse getByTimeslotId(Integer timeslotId);
}