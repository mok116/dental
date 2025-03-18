import React, { useState } from "react";
import RootLayout from "@/layouts/RootLayout";
import styles from "./Blogs.module.css";
import Carousel from "@/components/carousel/Carousel";
import BlogCard from "@/components/cards/BlogCard";
import Pagination from "@/components/pagination/Pagination";
import blogData from "@/data/blogData.json";
import BreadCrumb from "@/components/breadcrumb/BreadCrumb";

const Blogs: React.FC = () => {
  const [blogs, setBlogs] = useState<Array<{
    id: string;
    title: string;
    slug: string;
    snippet: string;
    content: string;
    date: string;
    image: string;
  }>>(blogData);
  const [currentPage, setCurrentPage] = useState(1);
  const itemsPerPage = 5;

  const indexOfLastItem = currentPage * itemsPerPage;
  const indexOfFirstItem = indexOfLastItem - itemsPerPage;
  const currentItems = blogs.slice(indexOfFirstItem, indexOfLastItem);

  const totalPages = Math.ceil(blogs.length / itemsPerPage);

  const handlePageChange = (page: number) => {
    setCurrentPage(page);
  };
  return (
    <RootLayout>
      {/* --- Carousel Section --- */}
      <section className={`${styles.blogsHero} container-fluid`}>
        <Carousel />
      </section>

      {/* --- Blog Cards Section + Pagination --- */}
      <section className={styles.section}>
        <div className={`${styles.articles} container`}>
          <h2 className="textHeader">Yazılar</h2>
          {currentItems.map((blog) => (
            <BlogCard
              key={blog.id}
              title={blog.title}
              snippet={blog.snippet}
              slug={blog.slug}
              date={blog.date}
              image={blog.image}
            />
          ))}
        </div>
        <Pagination
          currentPage={currentPage}
          totalPages={totalPages}
          onPageChange={handlePageChange}
        />
      </section>
    </RootLayout>
  );
};

export default Blogs;
