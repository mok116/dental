package com.example.demo.service;

import com.example.demo.model.Appointment;

import java.util.List;

public interface AppointmentService {

	void createAppointment(Appointment appointment);

	List<Appointment> getAppointmentsByPatient(Integer patientId);

	Appointment getAppointment(Integer id);

	List<Appointment> getAll();
}