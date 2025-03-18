package com.example.demo.serviceImpl;

import com.example.demo.model.Dentist;
import com.example.demo.repository.DentistRepository;
import com.example.demo.service.DentistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistServiceImpl implements DentistService {
    private final DentistRepository dentistRepository;

    public DentistServiceImpl(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }


    @Override
    public List<Dentist> getList() {
            List<Dentist> dentists = dentistRepository.findAll();
        if (dentists.isEmpty()) {
            throw new RuntimeException("clinic not found!");
        }
        return dentists;
    }

    @Override
    public Dentist getById(Integer id) {
        Optional<Dentist> dentist = dentistRepository.findById(id);
        if (dentist.isEmpty()) {
            throw new RuntimeException("clinic not found!");
        }
        return dentist.get();
    }
}