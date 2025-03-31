import React from "react";
import RootLayout from "@/layouts/RootLayout";
import { FaUser, FaCalendarAlt, FaClock, FaCheckCircle, FaTimesCircle } from "react-icons/fa";
import styles from "./Profile.module.css";

interface Appointment {
  id: string;
  date: string;
  time: string;
  treatment: string;
  status: "completed" | "upcoming" | "cancelled";
}

const Profile: React.FC = () => {
  // Mock data - replace with actual data from your backend
  const userInfo = {
    firstName: "John",
    lastName: "Doe",
    email: "john.doe@example.com",
    phone: "+1 234 567 8900",
    address: "123 Main St, City, Country",
  };

  const appointments: Appointment[] = [
    {
      id: "1",
      date: "2024-03-15",
      time: "10:00 AM",
      treatment: "Dental Cleaning",
      status: "completed",
    },
    {
      id: "2",
      date: "2024-03-20",
      time: "2:30 PM",
      treatment: "Teeth Whitening",
      status: "upcoming",
    },
    {
      id: "3",
      date: "2024-02-28",
      time: "11:00 AM",
      treatment: "Dental Check-up",
      status: "cancelled",
    },
  ];

  const getStatusIcon = (status: Appointment["status"]) => {
    switch (status) {
      case "completed":
        return <FaCheckCircle className={styles.statusIcon} />;
      case "cancelled":
        return <FaTimesCircle className={styles.statusIcon} />;
      default:
        return <FaClock className={styles.statusIcon} />;
    }
  };

  const getStatusColor = (status: Appointment["status"]) => {
    switch (status) {
      case "completed":
        return styles.statusCompleted;
      case "cancelled":
        return styles.statusCancelled;
      default:
        return styles.statusUpcoming;
    }
  };

  return (
    <RootLayout>
      <div className={styles.profileContainer}>
        {/* Basic Information Section */}
        <section className={styles.section}>
          <div className={styles.sectionHeader}>
            <FaUser className={styles.sectionIcon} />
            <h2>Basic Information</h2>
          </div>
          <div className={styles.infoGrid}>
            <div className={styles.infoItem}>
              <label>First Name</label>
              <p>{userInfo.firstName}</p>
            </div>
            <div className={styles.infoItem}>
              <label>Last Name</label>
              <p>{userInfo.lastName}</p>
            </div>
            <div className={styles.infoItem}>
              <label>Email</label>
              <p>{userInfo.email}</p>
            </div>
            <div className={styles.infoItem}>
              <label>Phone</label>
              <p>{userInfo.phone}</p>
            </div>
            <div className={styles.infoItem}>
              <label>Address</label>
              <p>{userInfo.address}</p>
            </div>
          </div>
        </section>

        {/* Appointment History Section */}
        <section className={styles.section}>
          <div className={styles.sectionHeader}>
            <FaCalendarAlt className={styles.sectionIcon} />
            <h2>Appointment History</h2>
          </div>
          <div className={styles.appointmentList}>
            {appointments.map((appointment) => (
              <div key={appointment.id} className={styles.appointmentCard}>
                <div className={styles.appointmentInfo}>
                  <h3>{appointment.treatment}</h3>
                  <p>
                    {appointment.date} at {appointment.time}
                  </p>
                </div>
                <div className={`${styles.statusBadge} ${getStatusColor(appointment.status)}`}>
                  {getStatusIcon(appointment.status)}
                  <span>{appointment.status.charAt(0).toUpperCase() + appointment.status.slice(1)}</span>
                </div>
              </div>
            ))}
          </div>
        </section>
      </div>
    </RootLayout>
  );
};

export default Profile; 