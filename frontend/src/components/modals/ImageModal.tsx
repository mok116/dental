import { IoIosArrowForward, IoIosArrowBack, IoMdClose } from "react-icons/io";
import React, { useEffect, useState } from "react";
import styles from "./ImageModal.module.css";
import Image, { StaticImageData } from "next/image";

interface ImageModalProps {
  isOpen: boolean;
  onClose: () => void;
  images: (string | StaticImageData)[];
  initialIndex: number;
}

const ImageModal: React.FC<ImageModalProps> = ({
  isOpen,
  onClose,
  images,
  initialIndex,
}) => {
  const [currentIndex, setCurrentIndex] = useState(initialIndex);

  useEffect(() => {
    setCurrentIndex(initialIndex);
  }, [initialIndex]);

  useEffect(() => {
    const handleKeyDown = (e: KeyboardEvent) => {
      if (e.key === "ArrowRight") {
        setCurrentIndex((prevIndex) => (prevIndex + 1) % images.length);
      } else if (e.key === "ArrowLeft") {
        setCurrentIndex(
          (prevIndex) => (prevIndex - 1 + images.length) % images.length
        );
      }
    };

    if (isOpen) {
      window.addEventListener("keydown", handleKeyDown);
    }

    return () => {
      window.removeEventListener("keydown", handleKeyDown);
    };
  }, [isOpen, images.length]);

  if (!isOpen) return null;

  const handleClose = () => {
    onClose();
  };

  const handleImageClick = (e: React.MouseEvent) => {
    e.stopPropagation();
  };

  return (
    <div className={styles.modalOverlay} onClick={handleClose}>
      <div className={styles.modalContent} onClick={handleImageClick}>
        <button className={styles.closeButton} onClick={handleClose}>
          <IoMdClose />
        </button>
        <Image
          src={images[currentIndex]}
          alt={`Image ${currentIndex + 1}`}
          className={styles.modalImage}
          fill={true}
        />
        <button
          className={`${styles.navButton} ${styles.left}`}
          onClick={() =>
            setCurrentIndex(
              (prevIndex) => (prevIndex - 1 + images.length) % images.length
            )
          }
          aria-label="Previous image"
          title="Previous image"
        >
          <IoIosArrowBack />
        </button>
        <button
          className={`${styles.navButton} ${styles.right}`}
          onClick={() =>
            setCurrentIndex((prevIndex) => (prevIndex + 1) % images.length)
          }
          aria-label="Next image"
          title="Next image"
        >
          <IoIosArrowForward />
        </button>
      </div>
    </div>
  );
};

export default ImageModal;
