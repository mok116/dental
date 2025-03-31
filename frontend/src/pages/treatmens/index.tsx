import {
  rootCanalImg,
  orthodontiaImg,
  maxillofacialSurgeryImg,
  implantImg,
  dentalRestorationImg,
  pediatricDentistryImg,
  teethWhiteningImg,
  toothExtractionImg,
  aestheticDentistryImg,
} from "@/utils/index";
import { CiCalendarDate, CiStethoscope } from "react-icons/ci";
import { RiToothLine } from "react-icons/ri";
import { MdOutlineHealthAndSafety } from "react-icons/md";
import React from "react";
import Image from "next/image";
import Link from "next/link";
import RootLayout from "@/layouts/RootLayout";
import ContactSection from "@/components/contact/ContactSection";
import styles from "./Treatments.module.css";
const Treatments: React.FC = () => {
  return (
    <RootLayout>
      {/* --- Hero Section --- */}
      <section className={`${styles.main} container-fluid`}>
        <div className={`${styles.treatmentsHero}`}>
          <h2 className={styles.textHeaderHero}>Our Treatments</h2>
          <p className={styles.subTextheaderHero}>
            Get your smile back with expert, experienced staff and advanced scientific technology!
          </p>
        </div>
      </section>

      {/* --- Treatment Steps Section --- */}
      <section className={`${styles.section}`}>
        <div className={`${styles.main} container`}>
          <h2 className={styles.stepsHeader}>Treatment Process</h2>
          <p className={styles.stepsSubheader}>
            You can contact us to get detailed information about oral and dental health treatments.
          </p>
          <div className={styles.stepsContainer}>
            <article>
              <h4>
                <CiCalendarDate size={24} /> Appointment Request
              </h4>
              <p>Request an appointment through our website or by phone.</p>
            </article>
            <article>
              <h4>
                <CiStethoscope size={24} /> Special Consultation
              </h4>
              <p>We evaluate your needs with our specialists.</p>
            </article>
            <article>
              <h4>
                <RiToothLine size={24} /> Personalized Treatment Plan
              </h4>
              <p>We create a personalized treatment plan for you.</p>
            </article>
            <article>
              <h4>
                <MdOutlineHealthAndSafety size={24} /> Follow-up and Support
              </h4>
              <p>We provide regular follow-up and support after treatment.</p>
            </article>
          </div>
        </div>
      </section>

      {/* --- Treatments Showcase --- */}
      <section className={`${styles.section}`}>
        <h2 className="textHeader container">Our Treatments</h2>
        <div className={`${styles.treatmentsContainer} container`}>
          <article>
            <figure>
              <picture>
                <Image src={rootCanalImg} alt="Root Canal Image" fill={true} />
              </picture>
            </figure>
            <span>Root Canal Treatment</span>
          </article>
          <article>
            <figure>
              <picture>
                <Image
                  src={orthodontiaImg}
                  alt="Orthodontial Image"
                  fill={true}
                />
              </picture>
            </figure>
            <span>Orthodontics</span>
          </article>
          <article>
            <figure>
              <picture>
                <Image
                  src={maxillofacialSurgeryImg}
                  alt="Maxillofacial Surgery Image"
                  fill={true}
                />
              </picture>
            </figure>
            <span>Maxillofacial Surgery</span>
          </article>
          <article>
            <figure>
              <picture>
                <Image
                  src={implantImg}
                  alt="Implant Operation Image"
                  fill={true}
                />
              </picture>
            </figure>
            <span>Dental Implants</span>
          </article>
          <article>
            <figure>
              <picture>
                <Image
                  src={aestheticDentistryImg}
                  alt="Aesthetic Dentistry Image"
                  fill={true}
                />
              </picture>
            </figure>
            <span>Aesthetic Dentistry</span>
          </article>
          <article>
            <figure>
              <picture>
                <Image
                  src={dentalRestorationImg}
                  alt="Dental Restoration Image"
                  fill={true}
                />
              </picture>
            </figure>
            <span>Dental Restoration</span>
          </article>

          <article>
            <figure>
              <picture>
                <Image
                  src={teethWhiteningImg}
                  alt="Teeth Whitening Image"
                  fill={true}
                />
              </picture>
            </figure>
            <span>Teeth Whitening</span>
          </article>

          <article>
            <figure>
              <picture>
                <Image
                  src={toothExtractionImg}
                  alt="Tooth Extraction Image"
                  fill={true}
                />
              </picture>
            </figure>
            <span>Wisdom Tooth Extraction</span>
          </article>

          <article>
            <figure>
              <picture>
                <Image
                  src={pediatricDentistryImg}
                  alt="Pediatric Dentistry Image"
                  fill={true}
                />
              </picture>
            </figure>
            <span>Pediatric Dentistry</span>
          </article>
        </div>
      </section>
      <ContactSection />
    </RootLayout>
  );
};

export default Treatments;
