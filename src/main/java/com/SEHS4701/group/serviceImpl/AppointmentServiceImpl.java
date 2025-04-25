package com.SEHS4701.group.serviceImpl;

import com.SEHS4701.group.dto.AppointmentByPatientIdResponse;
import com.SEHS4701.group.dto.AppointmentCreateRequest;
import com.SEHS4701.group.dto.AppointmentListResponse;
import com.SEHS4701.group.dto.AppointmentResponse;
import com.SEHS4701.group.model.Appointment;
import com.SEHS4701.group.model.AppointmentItem;
import com.SEHS4701.group.model.ClinicDentist;
import com.SEHS4701.group.model.DentistItem;
import com.SEHS4701.group.model.Patient;
import com.SEHS4701.group.repository.AppointmentRepository;
import com.SEHS4701.group.repository.ClinicDentistRepository;
import com.SEHS4701.group.repository.DentistItemRepository;
import com.SEHS4701.group.repository.PatientRepository;
import com.SEHS4701.group.service.AppointmentService;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final ModelMapper modelMapper;
    private final JavaMailSender mailSender;
    private final PatientRepository patientRepository;
    private final ClinicDentistRepository clinicDentistRepository;
    private final DentistItemRepository dentistItemRepository;
    private final SpringTemplateEngine templateEngine;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, ModelMapper modelMapper,
                                  JavaMailSender mailSender, PatientRepository patientRepository,
                                  ClinicDentistRepository clinicDentistRepository,
                                  DentistItemRepository dentistItemRepository,
                                  SpringTemplateEngine templateEngine) {
        this.appointmentRepository = appointmentRepository;
        this.modelMapper = modelMapper;
        this.mailSender = mailSender;
        this.patientRepository = patientRepository;
        this.clinicDentistRepository = clinicDentistRepository;
        this.dentistItemRepository = dentistItemRepository;
        this.templateEngine = templateEngine;
    }

    @Override
    @Transactional
    public int createAppointment(AppointmentCreateRequest appointmentCreateRequest) {
        try {
            // check Patient & ClinicDentist exist
            if(appointmentCreateRequest.getAppointmentDate().toLocalDate().equals(LocalDate.now())){
                throw new IllegalArgumentException("Appointment date cannot be today");
            }

            Patient patient = patientRepository.findById(appointmentCreateRequest.getPatientId())
                    .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + appointmentCreateRequest.getPatientId()));
            ClinicDentist clinicDentist = clinicDentistRepository.findById(appointmentCreateRequest.getClinicDentistId())
                    .orElseThrow(() -> new RuntimeException("ClinicDentist not found with ID: " + appointmentCreateRequest.getClinicDentistId()));

            // check duplicate appointment
            Optional<Appointment> existingAppointment = appointmentRepository.findByPatientIdAndClinicDentistIdAndAppointmentDate(
                    appointmentCreateRequest.getPatientId(),
                    appointmentCreateRequest.getClinicDentistId(),
                    appointmentCreateRequest.getAppointmentDate()
            );
            if (existingAppointment.isPresent()) {
                throw new RuntimeException("Duplicate appointment exists for this patient, clinic dentist, and date.");
            }

            // create Appointment
            Appointment appointment = new Appointment();
            appointment.setPatient(patient);
            appointment.setClinicDentist(clinicDentist);
            appointment.setAppointmentDate(appointmentCreateRequest.getAppointmentDate());
            appointment.setTotalAmount(appointmentCreateRequest.getTotalAmount());
            appointment.setStatus(appointmentCreateRequest.getStatus());

            // create AppointmentItems
            if (appointmentCreateRequest.getAppointmentItems() != null && !appointmentCreateRequest.getAppointmentItems().isEmpty()) {
                List<AppointmentItem> items = appointmentCreateRequest.getAppointmentItems().stream()
                        .map(itemDto -> {
                            AppointmentItem item = new AppointmentItem();
                            item.setAppointment(appointment);
                            DentistItem dentistItem = dentistItemRepository.findById(itemDto.getDentistItemId())
                                    .orElseThrow(() -> new RuntimeException("DentistItem not found with ID: " + itemDto.getDentistItemId()));
                            item.setDentistItem(dentistItem);
                            return item;
                        }).collect(Collectors.toList());
                appointment.setAppointmentItems(items);
            }

            // check appointment date within 3 months
            LocalDateTime maxDate = LocalDateTime.now().plusMonths(3);
            if (appointment.getAppointmentDate().isAfter(maxDate)) {
                throw new RuntimeException("Booking must be within the next 3 months!");
            }

            // save Appointment
            Appointment savedAppointment = appointmentRepository.save(appointment);

            // send email
            sendConfirmationEmail(appointment);
            return savedAppointment.getId();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create appointment: " + e.getMessage(), e);
        }
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
                }).collect(Collectors.toList()));
    }

    @Override
    public AppointmentResponse getAppointment(Integer id) {
        Appointment appointment = appointmentRepository.findByIdWithItems(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        AppointmentResponse.Appointment responseAppointment = modelMapper.map(appointment, AppointmentResponse.Appointment.class);
        responseAppointment.setPatient(modelMapper.map(appointment.getPatient(), AppointmentResponse.Patient.class));
        responseAppointment.setClinicDentist(modelMapper.map(appointment.getClinicDentist(), AppointmentResponse.ClinicDentist.class));
        return new AppointmentResponse(0, "success", responseAppointment);
    }

    @Override
    public AppointmentListResponse getAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        if (appointments.isEmpty()) {
            throw new RuntimeException("Appointment not found");
        }
        return new AppointmentListResponse(appointments.stream()
                .map(appointment -> {
                    AppointmentListResponse.Appointment dto = modelMapper.map(appointment, AppointmentListResponse.Appointment.class);
                    dto.setPatientId(appointment.getPatient().getId());
                    dto.setClinicDentistId(appointment.getClinicDentist().getId());
                    return dto;
                }).collect(Collectors.toList()));
    }

    private void sendConfirmationEmail(Appointment appointment) {
        try {
            // Create a MimeMessage
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            // Set email details
            helper.setTo(appointment.getPatient().getEmailAddress());
            helper.setSubject("Appointment Confirmation");


            // Prepare the Thymeleaf context with dynamic variables
            Context context = new Context();
            context.setVariable("patientName",
                    appointment.getPatient().getFirstName() + " " + appointment.getPatient().getLastName());
            context.setVariable("dentistName",
                    appointment.getClinicDentist().getDentist().getFirstName() + " " +
                            appointment.getClinicDentist().getDentist().getLastName());
            context.setVariable("clinicName",
                    appointment.getClinicDentist().getClinic().getName());
            context.setVariable("appointmentDate",
                    appointment.getAppointmentDate().format(DateTimeFormatter.ofPattern("MMMM d, yyyy 'at' h:mm a")));


            // Process the HTML template
            String htmlContent = templateEngine.process("appointment-confirmation", context);

            // Set the HTML content
            helper.setText(htmlContent, true); // true indicates HTML content

//            helper.addInline("logo", new ClassPathResource("\\static\\images\\logo.png"));

            // Send the email
            mailSender.send(message);
        } catch (Exception e) {
            System.err.println("Failed to send confirmation email: " + e.getMessage());
        }
    }
}