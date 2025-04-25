import React from 'react';
import RootLayout from '@/layouts/RootLayout';
import Link from 'next/link';
import styles from './Terms.module.css';

const Terms: React.FC = () => {
  return (
    <RootLayout>
      <div className={styles.termsContainer}>
        <h1>Terms and Conditions</h1>
        
        <section className={styles.section}>
          <h2>1. Introduction</h2>
          <p>
            Welcome to our dental clinic. By accessing our services, you agree to be bound by these Terms and Conditions.
          </p>
        </section>
        
        <section className={styles.section}>
          <h2>2. Privacy Policy</h2>
          <p>
            We respect your privacy and are committed to protecting your personal data in accordance with applicable laws.
          </p>
        </section>
        
        <section className={styles.section}>
          <h2>3. Patient Rights</h2>
          <p>
            You have the right to access, correct, or delete your personal information stored in our systems.
          </p>
        </section>
        
        <section className={styles.section}>
          <h2>4. Data Usage</h2>
          <p>
            We use your data solely for providing dental services and improving patient care.
          </p>
        </section>
        
        <section className={styles.section}>
          <h2>5. Changes to Terms</h2>
          <p>
            We may update these terms periodically. Continued use of our services constitutes acceptance of the updated terms.
          </p>
        </section>
        
        <div className={styles.backLink}>
          <Link href="/register">Back to Registration</Link>
        </div>
      </div>
    </RootLayout>
  );
};

export default Terms;