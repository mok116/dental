import {
  heroImage,
  rootCanalImg,
  orthodontiaImg,
  maxillofacialSurgeryImg,
  implantImg,
  dentalRestorationImg,
  pediatricDentistryImg,
  teethWhiteningImg,
  toothExtractionImg,
  aestheticDentistryImg,
  DentistAvatar,
} from "@/utils/index";
import teamData from "@/data/teamData.json";
import { FaPhoneAlt } from "react-icons/fa";
import { Swiper, SwiperSlide } from "swiper/react";
import { Pagination } from "swiper/modules";
import React, { useState } from "react";
import RootLayout from "@/layouts/RootLayout";
import Image from "next/image";
import Link from "next/link";
import Divider from "@/components/divider/Divider";
import TeamCard from "@/components/cards/TeamCard";
import TeamMember from '@/types/teamMember';
import MapComponent from "@/components/map/MapComponent";
import ContactSection from "@/components/contact/ContactSection";
import styles from "./Home.module.css";


const teamWithImages = teamData.map((member) => ({
  ...member,
  photoUrl: DentistAvatar,
}));

export default function Home() {
  const [team, setTeam] = useState<TeamMember[]>(teamWithImages);
  return (
    <RootLayout>
      {/* --- Hero Section --- */}
      <section>
        <div className={`${styles.heroContainer} container`}>
          <article>
            <h1>You're in the right place for Healthy Smiles!</h1>
            <p>
            Prioritize your oral health today - schedule your appointment with our dental team!
            </p>
            <p className={styles.contactHero}>
              <Link href="/contact">
                <FaPhoneAlt />
                Contact US
              </Link>
            </p>
          </article>
          <figure>
            <picture>
              <Image
                src={heroImage}
                alt="Hero Image"
                fill={true}
                quality={100}
              />
            </picture>
          </figure>
        </div>
      </section>

      <Divider text="Hong Kong Dental Care" />

      {/* --- Treatments Section ---  */}
      <section>
        <div className="container">
          <h2 className="textHeader">Our Treatments</h2>
          <h4 className="textSubheader" style={{marginBottom:"12px"}}>
          You can contact us to get detailed information about oral and dental health treatments.
          </h4>
          <div className={`${styles.treatmentsContainer}`}>
            <article>
              <figure>
                <picture>
                  <Image
                    src={rootCanalImg}
                    alt="Root Canal Image"
                    fill={true}
                  />
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
        </div>
      </section>

      <Divider text="Hong Kong Dental Care" />

      {/* --- Team Section ---  */}
      <section>
        <div className={`${styles.team} container`}>
          <h1>Our Team</h1>
          <Swiper
            spaceBetween={50}
            slidesPerView={1}
            breakpoints={{
              640: {
                slidesPerView: 1,
                spaceBetween: 20,
              },
              768: {
                slidesPerView: 2,
                spaceBetween: 40,
              },
              1024: {
                slidesPerView: 3,
                spaceBetween: 50,
              },
            }}
            pagination={{ clickable: true }}
            navigation={true}
            modules={[Pagination]}
          >
            {team.map((member, index) => (
              <SwiperSlide key={index}>
                <TeamCard
                  photoUrl={member.photoUrl}
                  slug={member.slug}
                  name={member.name}
                  title={member.title}
                  resumeUrl={member.resumeUrl}
                />
              </SwiperSlide>
            ))}
          </Swiper>
        </div>
      </section>

      <Divider text="Hong Kong Dental Care" />

      {/* --- Workhours Section ---  */}
      <section className={`${styles.workhourShowcase} container-fluid`}>
        {/* Top Wave. */}
        <svg
          data-name="Layer 1"
          xmlns="http://www.w3.org/2000/svg"
          viewBox="0 0 1200 120"
          preserveAspectRatio="none"
          className={styles.shapeTop}
        >
          <path d="M985.66,92.83C906.67,72,823.78,31,743.84,14.19c-82.26-17.34-168.06-16.33-250.45.39-57.84,11.73-114,31.07-172,41.86A600.21,600.21,0,0,1,0,27.35V120H1200V95.8C1132.19,118.92,1055.71,111.31,985.66,92.83Z"></path>
        </svg>
        {/* Bottom Wave. */}
        <svg
          data-name="Layer 2"
          xmlns="http://www.w3.org/2000/svg"
          viewBox="0 0 1200 120"
          preserveAspectRatio="none"
          className={styles.shapeBottom}
        >
          <path d="M321.39,56.44c58-10.79,114.16-30.13,172-41.86,82.39-16.72,168.19-17.73,250.45-.39C823.78,31,906.67,72,985.66,92.83c70.05,18.48,146.53,26.09,214.34,3V0H0V27.35A600.21,600.21,0,0,0,321.39,56.44Z"></path>
        </svg>
        <div className={`${styles.workhours} container`}>
          <article>
            <h1>Dental Clinic Working Hours</h1>
            <table className={styles.workhourTable}>
              <thead>
                <tr>
                  <th>Day</th>
                  <th>Hours</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>Monday</td>
                  <td>09:00 - 18:00</td>
                </tr>
                <tr>
                  <td>Tuesday</td>
                  <td>09:00 - 18:00</td>
                </tr>
                <tr>
                  <td>Wednesday</td>
                  <td>09:00 - 18:00</td>
                </tr>
                <tr>
                  <td>Thursday</td>
                  <td>09:00 - 18:00</td>
                </tr>
                <tr>
                  <td>Friday</td>
                  <td>09:00 - 18:00</td>
                </tr>
                <tr>
                  <td>Saturday</td>
                  <td>10:00 - 16:00</td>
                </tr>
                <tr>
                  <td>Sunday</td>
                  <td>Closed</td>
                </tr>
              </tbody>
            </table>
          </article>

          <figure>
            <svg
              width="800px"
              height="800px"
              viewBox="0 0 64 64"
              xmlns="http://www.w3.org/2000/svg"
            >
              <g fill="none" fillRule="evenodd">
                <g transform="translate(18 14)">
                  <path
                    fill="#B4DFFB"
                    d="M7.07142857,0 C2.81094622,0 0,4.89288809 0,10.9285714 C0,16.9642548 2.81094622,36 7.07142857,36 C9.55684234,36 9.83916051,20.1920244 13.1785714,20.177711 C17.1608395,20.1920244 16.8003005,36 19.2857143,36 C23.5461966,36 26.3571429,16.9642548 26.3571429,10.9285714 C26.3571429,4.89288809 23.5461966,0 19.2857143,0 C17.25,0 15.2142857,1.92857143 13.1785714,1.92857143 C11.1428571,1.92857143 9.10714286,0 7.07142857,0 Z"
                  />
                  <path
                    stroke="#FFF"
                    strokeLinecap="round"
                    strokeWidth="2"
                    d="M8.17857143,3 C5.41714768,3 3.17857143,5.23857625 3.17857143,8"
                  />
                </g>
                <path
                  stroke="#FFAF40"
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth="2"
                  d="M31,10 L31,4 M46.2027958,16.2972042 L50.4454365,12.0545635 M52.5,31.5 L58.5,31.5 M46.2027958,46.7027958 L50.4454365,50.9454365 M31,53 L31,59 M15.7972042,46.7027958 L11.5545635,50.9454365 M9.5,31.5 L3.5,31.5 M15.7972042,16.2972042 L11.5545635,12.0545635"
                />
              </g>
            </svg>
          </figure>
        </div>
      </section>

      {/* --- Map Location Section --- */}
      <section>
        <div className="container">
          <h2 className="textHeader">Clinic Location</h2>
          <MapComponent />
        </div>
      </section>
      
      <ContactSection/>
    </RootLayout>
  );
}
