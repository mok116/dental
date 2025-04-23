package com.SEHS4701.group.serviceImpl;

import com.SEHS4701.group.model.AppointmentItem;
import com.SEHS4701.group.repository.AppointmentItemRepository;
import com.SEHS4701.group.service.AppointmentItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentItemServiceImpl implements AppointmentItemService {
    private final AppointmentItemRepository appointmentItemRepository;

    public AppointmentItemServiceImpl(AppointmentItemRepository appointmentItemRepository) {
        this.appointmentItemRepository = appointmentItemRepository;
    }

    @Override
    public void create(AppointmentItem appointmentItem) {
        appointmentItemRepository.save(appointmentItem);
    }

    @Override
    public List<AppointmentItem> getByDentistItem(Integer dentistItemId) {
        List<AppointmentItem> appointmentItems = appointmentItemRepository.findByDentistItemId(dentistItemId);
        if (appointmentItems.isEmpty()) {
            throw new RuntimeException("Appointment Item not found");
        }
        return appointmentItems;
    }
}