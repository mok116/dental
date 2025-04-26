import { AiOutlineSchedule } from "react-icons/ai";
import React, { useEffect } from "react";
import RootLayout from "@/layouts/RootLayout";
import MultistepForm from "@/components/multistepform/MultistepForm";
import { useRouter } from "next/router";

import styles from "./GetAppointment.module.css";
const GetAppointment: React.FC = () => {
  const router = useRouter();

  useEffect(() => {
    const jwtToken = sessionStorage.getItem('jwtToken');
    if (!jwtToken) {
      router.push('/login');
    }
  }, [router]);

  return (
    <RootLayout>
      <section>
        <div className={`${styles.appointmentContainer} container`}>
          <AiOutlineSchedule />
          <h2>Online Appointment</h2>
          <MultistepForm />
        </div>
      </section>
    </RootLayout>
  );
};

export default GetAppointment;
