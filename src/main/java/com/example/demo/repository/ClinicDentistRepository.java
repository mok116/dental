package com.example.demo.repository;

import com.example.demo.model.ClinicDentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClinicDentistRepository extends JpaRepository<ClinicDentist, Integer> {
    List<ClinicDentist> findByClinicId(int clinicId);

    List<ClinicDentist> findByDentistId(int dentistId);

    List<ClinicDentist> findByTimeslotId(int timeslotId);
}