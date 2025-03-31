import React from "react";
import Link from "next/link";
import styles from "./ContactSection.module.css";

const ContactSection: React.FC = () => {
  return (
    <section className={styles.main}>
      <div className={`${styles.contactContainer} container-fluid`}>
        <h2 className={styles.contactHeader}>
          Contact Us to Find the Best Treatment Solution for You!
        </h2>
        <Link href="/contact">Contact</Link>
      </div>
    </section>
  );
};

export default ContactSection;
