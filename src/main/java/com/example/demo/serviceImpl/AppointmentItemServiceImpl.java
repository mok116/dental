package com.example.demo.serviceImpl;

import com.example.demo.model.AppointmentItem;
import com.example.demo.repository.AppointmentItemRepository;
import com.example.demo.service.AppointmentItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentItemServiceImpl implements AppointmentItemService {
    @Autowired
    private AppointmentItemRepository appointmentItemRepository;

    @Override
    public void create(AppointmentItem appointmentItem) {
        appointmentItemRepository.save(appointmentItem);
    }

    @Override
    public List<AppointmentItem> getByAppointmentId(Integer appointmentItemId) {
        List<AppointmentItem> appointmentItem = appointmentItemRepository.findByAppointmentId(appointmentItemId);
        if(appointmentItem.isEmpty()){
            throw new RuntimeException("Appointment Item not found");
        }
        return appointmentItem;
    }

    @Override
    public List<AppointmentItem> getByDentalItem(Integer dentalId) {
        List<AppointmentItem> appointmentItem = appointmentItemRepository.findByDentalItemId(dentalId);
        if(appointmentItem.isEmpty()){
            throw new RuntimeException("Appointment Item not found");
        }
        return appointmentItem;
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