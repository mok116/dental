package com.SEHS4701.group.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "dentist_items")
@Getter
@Setter
public class DentistItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Float fee;

    @Column(name = "dentist_id", insertable = false, updatable = false)
    private int dentistReferenceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    @Column(name = "item_id", insertable = false, updatable = false)
    private int itemReferenceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
}