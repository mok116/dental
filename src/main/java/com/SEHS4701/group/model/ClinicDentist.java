package com.SEHS4701.group.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "clinic_dentists")
@Getter
@Setter
public class ClinicDentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "clinic_id", insertable = false, updatable = false)
    private int clinicReferenceId;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @Column(name = "dentist_id", insertable = false, updatable = false)
    private int dentistReferenceId;

    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    @Column(name = "timeslot_id", insertable = false, updatable = false)
    private int timeslotReferenceId;

    @ManyToOne
    @JoinColumn(name = "timeslot_id")
    private Timeslot timeslot;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;
}