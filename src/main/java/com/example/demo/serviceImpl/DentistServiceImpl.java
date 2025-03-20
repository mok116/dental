package com.example.demo.serviceImpl;

import com.example.demo.dto.DentistListResponse;
import com.example.demo.model.Dentist;
import com.example.demo.repository.DentistRepository;
import com.example.demo.service.DentistService;
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
            throw new RuntimeException("clinic not found!");
        }
        return new DentistListResponse(dentists.stream()
                .map(dentist -> modelMapper.map(dentist, DentistListResponse.Dentist.class))
                .collect(Collectors.toList()));
    }

//    @Override
//    public DentistDTO getById(Integer id) {
//        Optional<Dentist> dentist = dentistRepository.findById(id);
//        if (dentist.isEmpty()) {
//            throw new RuntimeException("clinic not found!");
//        }
//        return dentist.get();
//    }
//
//    private DentistDTO mapToDTO(Dentist dentist) {
//        DentistDTO dto = new DentistDTO();
//    }
}