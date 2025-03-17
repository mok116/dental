package com.example.demo.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
//	List<Appointment> findByDentistIdAndDateAndTime(int dentistId, LocalDate date, LocalTime time);
//
//	List<Appointment> findByPatientId(int patientId);
}