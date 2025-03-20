package com.example.demo.serviceImpl;

import com.example.demo.dto.AppointmentByPatientIdResponse;
import com.example.demo.dto.AppointmentCreateRequest;
import com.example.demo.dto.AppointmentListResponse;
import com.example.demo.model.Appointment;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    private final ModelMapper modelMapper;

    private final JavaMailSender mailSender;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, ModelMapper modelMapper, JavaMailSender mailSender) {
        this.appointmentRepository = appointmentRepository;
        this.modelMapper = modelMapper;
        this.mailSender = mailSender;
    }


    @Override
    public void createAppointment(AppointmentCreateRequest appointmentCreateRequest) {
        Appointment appointment = modelMapper.map(appointmentCreateRequest, Appointment.class);
        appointment.setCreatedAt(LocalTime.now());
        appointmentRepository.save(appointment);
    }

    @Override
    public AppointmentByPatientIdResponse getAppointmentsByPatient(Integer patientId) {
        List<Appointment> appointments = appointmentRepository.findByPatientId(patientId);
        if (appointments.isEmpty()) {
            throw new RuntimeException("Appointment not found");
        }
        return new AppointmentByPatientIdResponse(appointments.stream()
                .map(appointment -> {
                    AppointmentByPatientIdResponse.Appointment dto = modelMapper.map(appointment, AppointmentByPatientIdResponse.Appointment.class);
                    dto.setPatientId(appointment.getPatient().getId());
                    dto.setClinicDentistId(appointment.getClinicDentist().getId());
                    return dto;
                }
        ).collect(Collectors.toList()));
    }

    @Override
    public Appointment getAppointment(Integer id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isEmpty()) {
            throw new RuntimeException("Appointment not found");
        }
        return appointment.get();
    }

    @Override
    public AppointmentListResponse getAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        if (appointments.isEmpty()) {
            throw new RuntimeException("Appointment not found");
        }
        return new AppointmentListResponse(appointments.stream().map(
                appointment -> modelMapper.map(appointment, AppointmentListResponse.Appointment.class)
        ).collect(Collectors.toList()));
    }


//    @Override
//	public String bookAppointment(Appointment appointment) {
//        // Check if within 3 months
//        LocalDate maxDate = LocalDate.now().plusMonths(3);
//        if (appointment.getDate().isAfter(maxDate)) {
//            return "Booking must be within the next 3 months!";
//        }
//
//        // Check availability
//        List<Appointment> existing = appointmentRepository.findByDentistIdAndDateAndTime(
//                appointment.getDentist().getId(), appointment.getDate(), appointment.getTime());
//        if (!existing.isEmpty()) {
//            return "Slot already booked!";
//        }
//
//        // Save appointment
//        appointmentRepository.save(appointment);
//
//        // Send email
//        //sendConfirmationEmail(appointment);
//        return null; // Success
//    }

//    private void sendConfirmationEmail(Appointment appointment) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(appointment.getPatient().getEmail());
//        message.setSubject("Appointment Confirmation");
//        message.setText("Dear " + appointment.getPatient().getName() + ",\n\n" +
//                "Your appointment with " + appointment.getDentist().getName() +
//                " at " + appointment.getClinics().getName() +
//                " on " + appointment.getDate() + " at " + appointment.getTime() +
//                " is confirmed.\n\nBest regards,\nHKDC Team");
//        mailSender.send(message);
//    }

//    @Override
//	public List<Appointment> getPatientAppointments(int patientId) {
//        return appointmentRepository.findByPatientId(patientId);
//    }
}