package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patients")
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String phone;
    private LocalDate createdAt;
    private LocalDate lastLoginAt;
    private String gender;
    private LocalDate dob;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    public Patient(LocalDate createdAt, LocalDate dob, String emailAddress, String firstName, String gender, int id, LocalDate lastLoginAt, String lastName, String password, String phone) {
        this.appointments = appointments;
        this.createdAt = createdAt;
        this.dob = dob;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.gender = gender;
        this.id = id;
        this.lastLoginAt = lastLoginAt;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
    }

    public Patient() {

    }
}