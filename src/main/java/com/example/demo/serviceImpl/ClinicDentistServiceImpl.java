package com.example.demo.serviceImpl;

import com.example.demo.model.ClinicDentist;
import com.example.demo.repository.ClinicDentistRepository;
import com.example.demo.service.ClinicDentistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicDentistServiceImpl implements ClinicDentistService {
    private final ClinicDentistRepository clinicdentistRepository;

    public ClinicDentistServiceImpl(ClinicDentistRepository clinicdentistRepository) {
        this.clinicdentistRepository = clinicdentistRepository;
    }


    @Override
    public List<ClinicDentist> getList() {
            List<ClinicDentist> clinicDentists = clinicdentistRepository.findAll();
        if (clinicDentists.isEmpty()) {
            throw new RuntimeException("clinic not found!");
        }
        return clinicDentists;
    }

    @Override
    public ClinicDentist getById(Integer id) {
        Optional<ClinicDentist> clinicDentist = clinicdentistRepository.findById(id);
        if (clinicDentist.isEmpty()) {
            throw new RuntimeException("clinic not found!");
        }
        return clinicDentist.get();
    }

    @Override
    public List<ClinicDentist> getByClinicId(Integer clinicId) {
        List<ClinicDentist> clinicDentist = clinicdentistRepository.findByClinicId(clinicId);
        if (clinicDentist.isEmpty()) {
            throw new RuntimeException("clinic not found!");
        }
        return clinicDentist;
    }

    @Override
    public List<ClinicDentist> getByDentistId(Integer dentistId) {
        List<ClinicDentist> clinicDentist = clinicdentistRepository.findByDentistId(dentistId);
        if (clinicDentist.isEmpty()) {
            throw new RuntimeException("clinic not found!");
        }
        return clinicDentist;
    }

    @Override
    public List<ClinicDentist> getByTimeslotId(Integer timeslotId) {
        List<ClinicDentist> clinicDentist = clinicdentistRepository.findByTimeslotId(timeslotId);
        if (clinicDentist.isEmpty()) {
            throw new RuntimeException("clinic not found!");
        }
        return clinicDentist;
    }
}