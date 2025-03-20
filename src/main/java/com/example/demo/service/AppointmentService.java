package com.example.demo.service;

import com.example.demo.dto.AppointmentByPatientIdResponse;
import com.example.demo.dto.AppointmentCreateRequest;
import com.example.demo.dto.AppointmentListResponse;
import com.example.demo.model.Appointment;

public interface AppointmentService {

	void createAppointment(AppointmentCreateRequest appointmentCreateRequest);

	AppointmentByPatientIdResponse getAppointmentsByPatient(Integer patientId);

	Appointment getAppointment(Integer id);

	AppointmentListResponse getAll();
}