import React from 'react';
import { FaCheckCircle } from 'react-icons/fa';
import styles from './SuccessPopup.module.css';

interface SuccessPopupProps {
  message: string;
  onClose: () => void;
}

const SuccessPopup: React.FC<SuccessPopupProps> = ({ message, onClose }) => {
  return (
    <div className={styles.overlay}>
      <div className={styles.popup}>
        <FaCheckCircle className={styles.icon} />
        <h3>Success!</h3>
        <p>{message}</p>
        <button onClick={onClose} className={styles.button}>
          OK
        </button>
      </div>
    </div>
  );
};

export default SuccessPopup; 