package com.SEHS4701.group.repository;

import com.SEHS4701.group.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
//	List<Appointment> findByDentistIdAndDateAndTime(int dentistId, LocalDate date, LocalTime time);
//
	List<Appointment> findByPatientId(int patientId);

	@Query("SELECT a FROM Appointment a LEFT JOIN FETCH a.appointmentItems WHERE a.id = :id")
    Optional<Appointment> findByIdWithItems(@Param("id") Integer id);
}