package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "appointments")
@Getter
@Setter
public class Appointment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "clinic_dentist_id")
    private ClinicDentist clinicDentist;

    @OneToMany(mappedBy = "appointment")
    private List<AppointmentItem> appointmentItems;

    private LocalDateTime appointmentDate;
    private String totalAmount;
    private String status;
    private LocalDateTime createdAt;
}