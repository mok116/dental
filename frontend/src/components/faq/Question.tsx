import { MdOutlineKeyboardArrowUp } from "react-icons/md";
import React, { useState, useRef, useEffect } from "react";
import styles from "./Question.module.css";

interface QuestionProps {
  title: string;
  answer: string;
}

const Question: React.FC<QuestionProps> = ({ title, answer }) => {
  const [isExpanded, setIsExpanded] = useState(false);
  const [answerHeight, setAnswerHeight] = useState('0px');
  const answerRef = useRef<HTMLDivElement>(null);

  const toggleAnswer = () => {
    setIsExpanded(!isExpanded);
  };

  useEffect(() => {
    if (answerRef.current) {
      setAnswerHeight(isExpanded ? `${answerRef.current.scrollHeight}px` : '0px');
    }
  }, [isExpanded]);

  return (
    <div className={`${styles.questionContainer} ${isExpanded ? styles.expanded : ''}`}>
      <div className={styles.questionInfo} onClick={toggleAnswer}>
        <span className={styles.questionTitle}>{title}</span>
        <span>
          <MdOutlineKeyboardArrowUp className={`${styles.rotateIcon} ${isExpanded ? styles.active : ''}`}/>
        </span>
      </div>
      <div
        ref={answerRef}
        className={styles.questionAnswer}
        style={{ height: answerHeight }}
      >
        <p>{answer}</p>
      </div>
    </div>
  );
};

export default Question;
