package com.SEHS4701.group.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private String password;

    private String phone;
    private String gender;
    private LocalDateTime dob;
    private LocalDateTime createdAt;
    private LocalDateTime lastLoginAt;

    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}