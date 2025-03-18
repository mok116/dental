import React from 'react';
import styles from './Divider.module.css';

interface DividerProps {
  text?: string;
  className?: string;
}

const Divider: React.FC<DividerProps> = ({ text, className }) => {
  return (
    <div className={`${styles.divider} ${className}`}>
      {text && <span className={styles.text}>{text}</span>}
    </div>
  );
};

export default Divider;
