package com.example.demo.repository;

import com.example.demo.model.Dentist;
import com.example.demo.model.DentistItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistItemRepository extends JpaRepository<DentistItem, Long> {
}