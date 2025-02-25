package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {}