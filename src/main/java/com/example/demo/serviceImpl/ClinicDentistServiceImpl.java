package com.example.demo.serviceImpl;

import com.example.demo.dto.*;
import com.example.demo.model.ClinicDentist;
import com.example.demo.repository.ClinicDentistRepository;
import com.example.demo.service.ClinicDentistService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClinicDentistServiceImpl implements ClinicDentistService {
    private final ClinicDentistRepository clinicdentistRepository;
    private final ModelMapper modelMapper;

    public ClinicDentistServiceImpl(ClinicDentistRepository clinicdentistRepository, ModelMapper modelMapper) {
        this.clinicdentistRepository = clinicdentistRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ClinicDentistListResponse getList() {
            List<ClinicDentist> clinicDentists = clinicdentistRepository.findAll();
        if (clinicDentists.isEmpty()) {
            throw new RuntimeException("clinic not found!");
        }
        return new ClinicDentistListResponse(clinicDentists.stream()
                .map(clinicDentist -> modelMapper.map(clinicDentist, ClinicDentistListResponse.ClinicDentist.class))
                .collect(Collectors.toList()));
    }

    @Override
    public ClinicDentistByIdResponse getById(Integer id) {
        ClinicDentist clinicDentist = clinicdentistRepository.findById(id).orElseThrow(() -> new RuntimeException("clinic not found!"));

        return new ClinicDentistByIdResponse(modelMapper.map(clinicDentist, ClinicDentistByIdResponse.ClinicDentist.class));
    }

    @Override
    public ClinicDentistByClinicIdResponse getByClinicId(Integer clinicId) {
        List<ClinicDentist> clinicDentists = clinicdentistRepository.findByClinicId(clinicId);
        if (clinicDentists.isEmpty()) {
            throw new RuntimeException("clinic not found!");
        }
        return new ClinicDentistByClinicIdResponse(clinicDentists.stream()
                .map(clinicDentist -> modelMapper.map(clinicDentist, ClinicDentistByClinicIdResponse.ClinicDentist.class))
        .collect(Collectors.toList()));
    }

    @Override
    public ClinicDentistByDentistIdResponse getByDentistId(Integer dentistId) {
        List<ClinicDentist> clinicDentists = clinicdentistRepository.findByDentistId(dentistId);
        if (clinicDentists.isEmpty()) {
            throw new RuntimeException("clinic not found!");
        }
        return new ClinicDentistByDentistIdResponse(clinicDentists.stream()
                .map(clinicDentist -> modelMapper.map(clinicDentist, ClinicDentistByDentistIdResponse.ClinicDentist.class))
        .collect(Collectors.toList()));
    }

    @Override
    public ClinicDentistByTimeslotIdResponse getByTimeslotId(Integer timeslotId) {
        List<ClinicDentist> clinicDentists = clinicdentistRepository.findByTimeslotId(timeslotId);
        if (clinicDentists.isEmpty()) {
            throw new RuntimeException("clinic not found!");
        }
        return new ClinicDentistByTimeslotIdResponse(clinicDentists.stream()
                .map(clinicDentist -> modelMapper.map(clinicDentist, ClinicDentistByTimeslotIdResponse.ClinicDentist.class))
                .collect(Collectors.toList()));
    }
}