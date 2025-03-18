package com.example.demo.service;

import com.example.demo.model.ClinicDentist;

import java.util.List;

public interface ClinicDentistService {

	List<ClinicDentist> getList();


	ClinicDentist getById(Integer id);

	List<ClinicDentist> getByClinicId(Integer clinicId);

	List<ClinicDentist> getByDentistId(Integer dentistId);

	List<ClinicDentist> getByTimeslotId(Integer timeslotId);
}