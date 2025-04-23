package com.SEHS4701.group.serviceImpl;

import com.SEHS4701.group.dto.DentistByIdResponse;
import com.SEHS4701.group.dto.DentistListResponse;
import com.SEHS4701.group.model.Dentist;
import com.SEHS4701.group.repository.DentistRepository;
import com.SEHS4701.group.service.DentistService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DentistServiceImpl implements DentistService {
    private final DentistRepository dentistRepository;
    private final ModelMapper modelMapper;

    public DentistServiceImpl(DentistRepository dentistRepository, ModelMapper modelMapper) {
        this.dentistRepository = dentistRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public DentistListResponse getList() {
            List<Dentist> dentists = dentistRepository.findAll();
        if (dentists.isEmpty()) {
            throw new RuntimeException("dentist not found!");
        }
        return new DentistListResponse(dentists.stream()
                .map(dentist -> modelMapper.map(dentist, DentistListResponse.Dentist.class))
                .collect(Collectors.toList()));
    }

    @Override
    public DentistByIdResponse getById(Integer id) {
        Dentist dentist = dentistRepository.findById(id).orElseThrow(() -> new RuntimeException("dentist not found!"));
        return new DentistByIdResponse(modelMapper.map(dentist, DentistByIdResponse.Dentist.class));
    }
}