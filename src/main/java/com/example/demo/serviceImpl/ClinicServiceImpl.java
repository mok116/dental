package com.example.demo.serviceImpl;

import com.example.demo.model.Clinic;
import com.example.demo.repository.ClinicRepository;
import com.example.demo.service.ClinicService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicServiceImpl implements ClinicService {
    private final ClinicRepository clinicRepository;

    public ClinicServiceImpl(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Override
    public List<Clinic> getList() {
            List<Clinic> clinics = clinicRepository.findAll();
        if (clinics.isEmpty()) {
            throw new RuntimeException("clinic not found!");
        }
        return clinics;
    }

    @Override
    public Clinic getById(Integer id) {
        Optional<Clinic> clinic = clinicRepository.findById(id);
        if (clinic.isEmpty()) {
            throw new RuntimeException("clinic not found!");
        }
        return clinic.get();
    }
}