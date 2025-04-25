package com.SEHS4701.group.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class AppointmentByIdResponse extends BaseResponse {
    private Appointment appointment;
    
    public AppointmentByIdResponse(Appointment appointment) {
        this.appointment = appointment;
    }

    @Getter
    @Setter
    public static class Appointment {
        private int id;
        private Patient patient;
        private ClinicDentist clinicDentist;
        private List<AppointmentItem> appointmentItems;
        private LocalDateTime appointmentDate;
        private int totalAmount;
        private String status;
        private LocalDateTime createdAt;
    }

    @Getter
    @Setter
    public static class Patient {
        private int id;
        private String firstName;
        private String lastName;
        private String emailAddress;
        private String phone;
        private String gender;
        private LocalDateTime dob;
    }

    @Getter
    @Setter
    public static class ClinicDentist {
        private int id;
        private Dentist dentist;
        private Clinic clinic;
    }

    @Getter
        @Setter
        public static class Clinic {
            private Integer id;
            private String name;
            private String address;
            private String district;
            private String phone;
            private String openHours;
        }

        @Getter
        @Setter
        public static class Dentist {
            private Integer id;
            private String firstName;
            private String lastName;
            private String gender;
            private String emailAddress;
            private String imageUrl;
        }

    @Getter
    @Setter
    public static class AppointmentItem {
        private int id;
        private DentistItem dentistItem;
    }

    @Getter
    @Setter
    public static class DentistItem {
        private int id;
        private Dentist dentist;
        private Item item;
        private Float fee;
    }

    @Getter
    @Setter
    public static class Item {
        private Integer id;
        private String name;
    }
}