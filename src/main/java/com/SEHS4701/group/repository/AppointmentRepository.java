package com.SEHS4701.group.repository;

import com.SEHS4701.group.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
//
	List<Appointment> findByPatientId(int patientId);

	@Query("SELECT a FROM Appointment a LEFT JOIN FETCH a.appointmentItems WHERE a.id = :id")
    Optional<Appointment> findByIdWithItems(@Param("id") Integer id);

	@Query("SELECT a FROM Appointment a WHERE a.status = :status AND a.clinicDentist.id = :clinicDentistId AND a.appointmentDate = :appointmentDate")
    Optional<Appointment> findByPatientIdAndClinicDentistIdAndAppointmentDate(
            @Param("status") String status,
            @Param("clinicDentistId") Integer clinicDentistId,
            @Param("appointmentDate") LocalDateTime appointmentDate);

    @Query("SELECT a FROM Appointment a WHERE a.clinicDentist.id IN :clinicDentistIds AND CAST(a.appointmentDate AS DATE) = :appointmentDate")
    List<Appointment> findByClinicDentistIdInAndAppointmentDate(
            @Param("clinicDentistIds") List<Integer> clinicDentistIds,
            @Param("appointmentDate") LocalDate appointmentDate);
}