package com.SEHS4701.group.service;

import com.SEHS4701.group.dto.AppointmentByPatientIdResponse;
import com.SEHS4701.group.dto.AppointmentCreateRequest;
import com.SEHS4701.group.dto.AppointmentListResponse;
import com.SEHS4701.group.model.Appointment;

public interface AppointmentService {

	void createAppointment(AppointmentCreateRequest appointmentCreateRequest);

	AppointmentByPatientIdResponse getAppointmentsByPatient(Integer patientId);

	Appointment getAppointment(Integer id);

	AppointmentListResponse getAll();
}