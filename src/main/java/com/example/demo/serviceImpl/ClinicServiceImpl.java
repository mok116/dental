package com.example.demo.serviceImpl;

import com.example.demo.dto.ClinicByIdResponse;
import com.example.demo.dto.ClinicListResponse;
import com.example.demo.model.Clinic;
import com.example.demo.repository.ClinicRepository;
import com.example.demo.service.ClinicService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClinicServiceImpl implements ClinicService {
    private final ClinicRepository clinicRepository;
    private final ModelMapper modelMapper;

    public ClinicServiceImpl(ClinicRepository clinicRepository, ModelMapper modelMapper) {
        this.clinicRepository = clinicRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ClinicListResponse getList() {
        List<Clinic> clinics = clinicRepository.findAll();
        if (clinics.isEmpty()) {
            throw new RuntimeException("clinic not found!");
        }
        return new ClinicListResponse(clinics.stream().map(clinic ->
                modelMapper.map(clinic, ClinicListResponse.Clinic.class)).collect(Collectors.toList()));
    }

    @Override
    public ClinicByIdResponse getById(Integer id) {
        Clinic clinic = clinicRepository.findById(id).orElseThrow(() -> new RuntimeException("clinic not found!"));
        return new ClinicByIdResponse(modelMapper.map(clinic, ClinicByIdResponse.Clinic.class));
    }
}