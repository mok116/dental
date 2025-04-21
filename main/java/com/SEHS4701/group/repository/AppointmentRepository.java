package com.SEHS4701.group.repository;

import com.SEHS4701.group.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
//	List<Appointment> findByDentistIdAndDateAndTime(int dentistId, LocalDate date, LocalTime time);
//
	List<Appointment> findByPatientId(int patientId);
}