import React from 'react';
import styles from './TextArea.module.css';

interface TextAreaProps {
  placeholder: string;
  value: string;
  onChange: (e: React.ChangeEvent<HTMLTextAreaElement>) => void;
  id?: string;
}

const TextArea: React.FC<TextAreaProps> = ({ placeholder, value, id, onChange }) => {
  return (
    <div className={styles.main}>
      <textarea
        name={id}
        id={id}
        placeholder=""
        value={value}
        onChange={onChange}
        required
      />
      <label htmlFor={id}>
        {placeholder}
      </label>
    </div>
  );
};

export default TextArea;
