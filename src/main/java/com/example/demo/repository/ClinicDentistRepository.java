package com.example.demo.repository;

import com.example.demo.model.Clinic;
import com.example.demo.model.ClinicDentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicDentistRepository extends JpaRepository<ClinicDentist, Long> {}