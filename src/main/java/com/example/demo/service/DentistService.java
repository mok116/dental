package com.example.demo.service;

import com.example.demo.model.Dentist;

import java.util.List;

public interface DentistService {

	List<Dentist> getList();


	Dentist getById(Integer id);
}