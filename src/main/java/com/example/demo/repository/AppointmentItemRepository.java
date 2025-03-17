package com.example.demo.repository;

import com.example.demo.model.Appointment;
import com.example.demo.model.AppointmentItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentItemRepository extends JpaRepository<AppointmentItem, Integer> {

}