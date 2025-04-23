package com.SEHS4701.group.model;

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

    @Column(name = "appointment_date")
    private LocalDateTime appointmentDate;

    @Column(name = "total_amount")
    private int totalAmount;

    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}