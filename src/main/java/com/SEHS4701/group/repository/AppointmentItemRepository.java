package com.SEHS4701.group.repository;

import com.SEHS4701.group.model.AppointmentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentItemRepository extends JpaRepository<AppointmentItem, Integer> {
    List<AppointmentItem> findByDentistItemId(Integer dentistItemId);
}