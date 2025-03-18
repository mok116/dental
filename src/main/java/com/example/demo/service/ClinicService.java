package com.example.demo.service;

import com.example.demo.model.Clinic;

import java.util.List;

public interface ClinicService {

	List<Clinic> getList();

	Clinic getById(Integer id);
}