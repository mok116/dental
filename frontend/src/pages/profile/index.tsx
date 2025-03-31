import React, { useEffect, useState } from 'react';
import RootLayout from '@/layouts/RootLayout';
import styles from './Profile.module.css';
import { useRouter } from 'next/router';
import { FaUser, FaCalendarAlt, FaClock, FaCheckCircle, FaTimesCircle, FaSignOutAlt } from "react-icons/fa";

interface Patient {
  id: number;
  firstName: string;
  lastName: string;
  emailAddress: string;
  gender: string;
  dob: string;
  phone: string;
}

interface Appointment {
  id: string;
  date: string;
  time: string;
  treatment: string;
  status: "completed" | "upcoming" | "cancelled";
}

const Profile: React.FC = () => {
  const router = useRouter();
  const [patient, setPatient] = useState<Patient | null>(null);

  // Mock data for appointments - replace with actual data from your backend
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

  useEffect(() => {
    // Check if user is logged in
    const jwtToken = sessionStorage.getItem('jwtToken');
    const patientInfo = sessionStorage.getItem('patientInfo');

    if (!jwtToken || !patientInfo) {
      router.push('/login');
      return;
    }

    // Parse and set patient information
    setPatient(JSON.parse(patientInfo));
  }, [router]);

  const handleLogout = () => {
    // Clear session storage
    sessionStorage.removeItem('jwtToken');
    sessionStorage.removeItem('patientInfo');
    // Redirect to login page
    router.push('/login');
  };

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

  if (!patient) {
    return null;
  }

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
              <p>{patient.firstName}</p>
            </div>
            <div className={styles.infoItem}>
              <label>Last Name</label>
              <p>{patient.lastName}</p>
            </div>
            <div className={styles.infoItem}>
              <label>Email</label>
              <p>{patient.emailAddress}</p>
            </div>
            <div className={styles.infoItem}>
              <label>Phone</label>
              <p>{patient.phone}</p>
            </div>
            <div className={styles.infoItem}>
              <label>Gender</label>
              <p>{patient.gender === 'M' ? 'Male' : 'Female'}</p>
            </div>
            <div className={styles.infoItem}>
              <label>Date of Birth</label>
              <p>{new Date(patient.dob).toLocaleDateString()}</p>
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

        {/* Logout Button */}
        <div className={styles.logoutContainer}>
          <button onClick={handleLogout} className={styles.logoutButton}>
            <FaSignOutAlt className={styles.logoutIcon} />
            Logout
          </button>
        </div>
      </div>
    </RootLayout>
  );
};

export default Profile; 