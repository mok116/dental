package com.example.demo.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.model.Appointment;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Override
	public String bookAppointment(Appointment appointment) {
        // Check if within 3 months
        LocalDate maxDate = LocalDate.now().plusMonths(3);
        if (appointment.getDate().isAfter(maxDate)) {
            return "Booking must be within the next 3 months!";
        }

        // Check availability
        List<Appointment> existing = appointmentRepository.findByDentistIdAndDateAndTime(
                appointment.getDentist().getId(), appointment.getDate(), appointment.getTime());
        if (!existing.isEmpty()) {
            return "Slot already booked!";
        }

        // Save appointment
        appointmentRepository.save(appointment);

        // Send email
        //sendConfirmationEmail(appointment);  
        return null; // Success
    }

    private void sendConfirmationEmail(Appointment appointment) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(appointment.getPatient().getEmail());
        message.setSubject("Appointment Confirmation");
        message.setText("Dear " + appointment.getPatient().getName() + ",\n\n" +
                "Your appointment with " + appointment.getDentist().getName() + 
                " at " + appointment.getClinic().getName() + 
                " on " + appointment.getDate() + " at " + appointment.getTime() + 
                " is confirmed.\n\nBest regards,\nHKDC Team");
        mailSender.send(message);
    }

    @Override
	public List<Appointment> getPatientAppointments(int patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
}