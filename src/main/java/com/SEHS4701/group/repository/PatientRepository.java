package com.SEHS4701.group.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SEHS4701.group.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	Optional<Patient> findByEmailAddress(String emailAddress);
}