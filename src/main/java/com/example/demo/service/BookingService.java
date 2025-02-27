package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Appointment;

public interface BookingService {

	String bookAppointment(Appointment appointment);

	List<Appointment> getPatientAppointments(int patientId);

}