package com.SEHS4701.group.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clinics")
@Getter
@Setter
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String district;
    private String phone;
    private String openHours;

    @OneToMany(mappedBy = "clinic", fetch = FetchType.EAGER)
    private List<ClinicDentist> clinicDentists;

}