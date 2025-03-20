package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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
    private LocalDateTime createdAt;
    private LocalDateTime lastLoginAt;
    private String gender;
    private LocalDateTime dob;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}