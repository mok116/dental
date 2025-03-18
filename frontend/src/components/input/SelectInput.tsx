import React from 'react';
import styles from './SelectInput.module.css';

interface SelectComponentProps {
  placeholder: string;
  value: string;
  onChange: (e: React.ChangeEvent<HTMLSelectElement>) => void;
  options: { value: string; label: string }[];
  id?: string;
}

const SelectComponent: React.FC<SelectComponentProps> = ({ placeholder, value, onChange, options, id }) => {
  return (
    <div className={styles.main}>
      <select
        id={id}
        value={value}
        onChange={onChange}
        required
      >
        <option value="" disabled hidden>{placeholder}</option>
        {options.map((option) => (
          <option key={option.value} value={option.value}>
            {option.label}
          </option>
        ))}
      </select>
    </div>
  );
};

export default SelectComponent;
