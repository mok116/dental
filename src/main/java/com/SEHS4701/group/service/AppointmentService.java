package com.SEHS4701.group.service;

import com.SEHS4701.group.dto.AppointmentByPatientIdResponse;
import com.SEHS4701.group.dto.AppointmentCreateRequest;
import com.SEHS4701.group.dto.AppointmentListResponse;
import com.SEHS4701.group.dto.BookedClinicDentistIdsResponse;

import java.time.LocalDate;

import com.SEHS4701.group.dto.AppointmentByIdResponse;

public interface AppointmentService {
	
    int createAppointment(AppointmentCreateRequest appointmentCreateRequest);

    void cancelAppointment(Integer appointmentId);

    AppointmentByPatientIdResponse getAppointmentsByPatient(Integer patientId);

    AppointmentByIdResponse getById(Integer id);

    AppointmentListResponse getAll();

    BookedClinicDentistIdsResponse getBookedClinicDentistIds(Integer clinicId, Integer dentistId, LocalDate appointmentDate);
}