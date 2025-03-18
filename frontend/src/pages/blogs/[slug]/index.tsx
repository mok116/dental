import { CiTimer } from "react-icons/ci";
import { MdOutlineDateRange } from "react-icons/md";
import { RootState } from "@/store/store";
import { useSelector } from "react-redux";
import React from "react";
import RootLayout from "@/layouts/RootLayout";
import { rootCanalImg } from "@/utils/imageExporter";
import Image from "next/image";
import { Swiper, SwiperSlide } from "swiper/react";
import { Pagination } from "swiper/modules";
import "swiper/css";
import "swiper/css/navigation";
import styles from "./Blog.module.css";
import RecommendCard from "@/components/cards/RecommendCard";
import blogData from "@/data/blogData.json";

const Blog = () => {
  const { title, photoUrl } = useSelector((state: RootState) => state.blog);

  return (
    <RootLayout>
      <section className={styles.main}>
        <div className={`${styles.blogContainer} container`}>
          
          <figure>
            <picture>
              <Image
                src={photoUrl || rootCanalImg}
                alt="Blog Image"
                fill={true}
              />
            </picture>
          </figure>
          <article>
            <h2 className="textHeader">
              {title || "Hey tester! It is only frontend :)"}{" "}
            </h2>
            <div className={styles.blogInfo}>
              <span>
                <CiTimer/>
                5min read
              </span>
              <span>
                <MdOutlineDateRange/>
                22-08-2024
              </span>
            </div>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Quaerat
              corrupti doloribus repellendus voluptas? Nemo, at est fuga illo
              corrupti veritatis? Lorem ipsum dolor sit amet consectetur
              adipisicing elit. Ea fugiat iusto expedita, quae sed voluptatibus
              tempora non saepe excepturi dicta animi culpa quod veniam eligendi
              consectetur. Adipisci fugiat deleniti debitis doloremque sunt
              natus vel voluptates, neque quo, quis quibusdam accusantium.
            </p>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Quaerat
              corrupti doloribus repellendus voluptas? Nemo, at est fuga illo
              corrupti veritatis? Lorem ipsum, dolor sit amet consectetur
              adipisicing elit. Aspernatur natus officiis, dolorum, amet hic
              perspiciatis incidunt deserunt quam sit eos error commodi
              necessitatibus est officia harum molestiae quo nam quos odio quis
              nesciunt saepe facilis veritatis. Fugit deleniti inventore vero?
            </p>

            <h4 className={`${styles.mockTitle} textSubheader`}>Another header</h4>

            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Quaerat
              corrupti doloribus repellendus voluptas? Nemo, at est fuga illo
              corrupti veritatis? Lorem ipsum dolor sit amet consectetur
              adipisicing elit. Ea fugiat iusto expedita, quae sed voluptatibus
              tempora non saepe excepturi dicta animi culpa quod veniam eligendi
              consectetur. Adipisci fugiat deleniti debitis doloremque sunt
              natus vel voluptates, neque quo, quis quibusdam accusantium.
            </p>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Quaerat
              corrupti doloribus repellendus voluptas? Nemo, at est fuga illo
              corrupti veritatis? Lorem ipsum, dolor sit amet consectetur
              adipisicing elit. Aspernatur natus officiis, dolorum, amet hic
              perspiciatis incidunt deserunt quam sit eos error commodi
              necessitatibus est officia harum molestiae quo nam quos odio quis
              nesciunt saepe facilis veritatis. Fugit deleniti inventore vero?
            </p>
          </article>
        </div>
      </section>

      <section className={styles.section}>
        <div className="container">
          <h2
            className="textHeader"
            style={{ fontSize: "var(--font-size-lg)" }}
          >
            Diğer İçerikler
          </h2>
          <div className={`${styles.recommendContainer}`}>
            <Swiper
              spaceBetween={50}
              slidesPerView={1}
              className="mySwiper"
              breakpoints={{
                576: {
                  slidesPerView: 1,
                  spaceBetween: 20,
                },
                768: {
                  slidesPerView: 2,
                  spaceBetween: 40,
                },
                992: {
                  slidesPerView: 3,
                  spaceBetween: 50,
                },
              }}
              pagination={{ clickable: true }}
              modules={[Pagination]}
            >
              {blogData.map((item) => (
                <SwiperSlide key={item.id}>
                  <RecommendCard
                    title={item.title}
                    photoUrl={item.image}
                    slug={item.slug}
                  />
                </SwiperSlide>
              ))}
            </Swiper>
          </div>
        </div>
      </section>
    </RootLayout>
  );
};

export default Blog;
