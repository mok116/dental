package com.example.demo.serviceImpl;

import com.example.demo.model.DentistItem;
import com.example.demo.repository.DentistItemRepository;
import com.example.demo.service.DentistItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistItemServiceImpl implements DentistItemService {
    private final DentistItemRepository dentistRepository;


    public DentistItemServiceImpl(DentistItemRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }


    @Override
    public List<DentistItem> getList() {
        List<DentistItem> dentists = dentistRepository.findAll();
        if(dentists.isEmpty()) {
            throw new RuntimeException("No dentist item found");
        }
        return dentists;
    }

    @Override
    public DentistItem getById(Integer id) {
        Optional<DentistItem> dentist = dentistRepository.findById(id);
        if(dentist.isEmpty()) {
            throw new RuntimeException("No dentist item found");
        }
        return dentist.get();
    }

    @Override
    public List<DentistItem> getByDentistId(Integer dentistId) {
        List<DentistItem> dentists = dentistRepository.findDentistItemByDentistId(dentistId);
        if(dentists.isEmpty()) {
            throw new RuntimeException("No dentist item found");
        }
        return dentists;
    }
}