package com.SEHS4701.group.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @Column(name = "dentist_id", insertable = false, updatable = false)
    private int dentistReferenceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    @Column(name = "time_slot_id", insertable = false, updatable = false)
    private int timeslotReferenceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "time_slot_id")
    private Timeslot timeslot;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;
}