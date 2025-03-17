package com.example.demo.repository;

import com.example.demo.model.Patient;
import com.example.demo.model.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeslotRepository extends JpaRepository<Timeslot, Integer> {

}