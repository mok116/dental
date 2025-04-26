package com.SEHS4701.group.serviceImpl;

import com.SEHS4701.group.dto.EditRequest;
import com.SEHS4701.group.dto.LoginResponse;
import com.SEHS4701.group.dto.PatientByIdResponse;
import com.SEHS4701.group.dto.RegisterRequest;
import com.SEHS4701.group.model.Patient;
import com.SEHS4701.group.repository.PatientRepository;
import com.SEHS4701.group.security.JwtUtil;
import com.SEHS4701.group.service.PatientService;
import com.SEHS4701.group.service.VerificationCodeStore;
import jakarta.mail.internet.MimeMessage;
import org.modelmapper.ModelMapper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;
    private final VerificationCodeStore codeStore;

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final int MIN_EMAIL_LENGTH = 8;
    private static final long TOKEN_EXPIRY_MINUTES = 60; // 1 小時

    public PatientServiceImpl(PatientRepository patientRepository, ModelMapper modelMapper,
                              JwtUtil jwtUtil, PasswordEncoder passwordEncoder,
                              JavaMailSender mailSender, SpringTemplateEngine templateEngine,
                              VerificationCodeStore codeStore) {
        this.patientRepository = patientRepository;
        this.modelMapper = modelMapper;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
        this.codeStore = codeStore;
    }

    @Override
    public int registerPatient(RegisterRequest registerRequest) {

        String email = registerRequest.getEmailAddress();
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new RuntimeException("Invalid email format!");
        }

        if (email.length() < MIN_EMAIL_LENGTH) {
            throw new RuntimeException("Email must be at least 8 characters long!");
        }

        Optional<Patient> registeredPatient = patientRepository.findByEmailAddress(registerRequest.getEmailAddress());
        if (registeredPatient.isPresent() && registeredPatient.get().getEmailAddress().equals(registerRequest.getEmailAddress())) {
            throw new RuntimeException("Email already registered!");
        }

        Patient patient = modelMapper.map(registerRequest, Patient.class);
        patient.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        patient.setCreatedAt(LocalDateTime.now());
        Patient savedPatient = patientRepository.save(patient);
        return savedPatient.getId();
    }

    @Override
    public LoginResponse login(String email, String password) {

        Optional<Patient> loginPatientOpt = patientRepository.findByEmailAddress(email);
        if (loginPatientOpt.isEmpty()
                || !passwordEncoder.matches(password, loginPatientOpt.get().getPassword())
        ) {
            throw new RuntimeException("Invalid credentials!");
        }
        
        Patient loginPatient = loginPatientOpt.get();
        loginPatient.setLastLoginAt(LocalDateTime.now());
        patientRepository.save(loginPatient);

        LoginResponse.Patient patient = modelMapper.map(loginPatient, LoginResponse.Patient.class);
        String token = jwtUtil.generateToken(email);
        return new LoginResponse(0, token, patient);
    }

    @Override
    public PatientByIdResponse getById(Integer id) {
            Patient patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found!"));
        return new PatientByIdResponse(modelMapper.map(patient, PatientByIdResponse.Patient.class));
    }

    @Override
    public void edit(EditRequest editRequest) {
        Patient existingPatient = patientRepository.findById(editRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        modelMapper.map(editRequest, existingPatient);
        patientRepository.save(existingPatient);
    }

    @Override
    public void sendPasswordResetEmail(String email) {
        Optional<Patient> patientOpt = patientRepository.findByEmailAddress(email);
        if (patientOpt.isEmpty()) {
            throw new RuntimeException("Email not registered!");
        }

        String code = codeStore.generateCode(email);

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(email);
            helper.setSubject("Password Reset Request");

            Context context = new Context();
            context.setVariable("patientName", patientOpt.get().getFirstName() + " " + patientOpt.get().getLastName());
            context.setVariable("resetUrl", "http://localhost:3000/reset-password?email=" + email + "&code=" + code);
            context.setVariable("expiryMinutes", TOKEN_EXPIRY_MINUTES);

            String htmlContent = templateEngine.process("password-reset", context);
            helper.setText(htmlContent, true);

            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send password reset email: " + e.getMessage());
        }
    }

    @Override
    public void resetPassword(String email, String code, String newPassword) {
        if (!codeStore.validateCode(email, code)) {
            throw new RuntimeException("Invalid or expired verification code!");
        }

        Patient patient = patientRepository.findByEmailAddress(email)
                .orElseThrow(() -> new RuntimeException("Patient not found!"));

        patient.setPassword(passwordEncoder.encode(newPassword));
        patientRepository.save(patient);

        codeStore.markCodeAsUsed(email);
    }
}