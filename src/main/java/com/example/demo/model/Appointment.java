package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "appointments")
@Getter
@Setter
public class Appointment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "clinic_dentist_id")
    private ClinicDentist clinicDentist;

    @OneToMany(mappedBy = "appointment")
    private List<AppointmentItem> appointmentItems;

    private LocalTime appointmentDate;
    private String totalAmount;
    private String status;
    private LocalTime createAt;
}