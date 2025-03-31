import React, { useState } from "react";
import { useRouter } from "next/router";
import TextInput from "../input/TextInput";
import TextArea from "../input/TextArea";
import SelectComponent from "../input/SelectInput";
import { MdArrowBack, MdArrowForward } from "react-icons/md";
import { LiaClipboardCheckSolid } from "react-icons/lia";
import { DayPicker } from "react-day-picker";
import Swal from "sweetalert2";
import styles from "./MultistepForm.module.css";
import PhoneNumberInput from "../input/NumberInput";

interface FormData {
  firstName: string;
  midinit: string;
  lastName: string;
  phone: number;
  appointmentDate: Date | undefined;
  selectedDoctor: string;
  patienceNote: string;
}

const MultistepForm: React.FC = () => {
  const router = useRouter();
  const [currentIndex, setCurrentIndex] = useState(0);
  const [formData, setFormData] = useState<FormData>({
    firstName: "",
    midinit: "",
    lastName: "",
    phone: 0,
    appointmentDate: undefined,
    selectedDoctor: "",
    patienceNote: "",
  });
  const [selected, setSelected] = useState<Date | undefined>(undefined);
  const [isButtonDisabled, setIsButtonDisabled] = useState<boolean>(true);

  const doctors = [
    { value: "dt-yusuf-ridvan-dilek", label: "Dr. Yusuf Ridvan Dilek" },
    { value: "dr-mehmet-ozturk", label: "Dr. Mehmet Ozturk" },
    { value: "dr-ali-can", label: "Dr. Ali Can" },
    { value: "dr-ahmet-demir", label: "Dr. Ahmet Demir" },
    { value: "dr-mustafa-yildiz", label: "Dr. Mustafa Yildiz" },
    { value: "dr-burak-aydin", label: "Dr. Burak Aydin" },
  ];

  const handleInputChange = (
    e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
  ) => {
    const { id, value, tagName } = e.target;

    if (tagName === "INPUT" || tagName === "TEXTAREA") {
      setFormData((prevData) => ({
        ...prevData,
        [id]: value,
      }));
    }
  };

  const handleDateChange = (date: Date | undefined) => {
    setSelected(date);
    setFormData((prevData) => ({
      ...prevData,
      appointmentDate: date,
    }));
  };

  const handleSelectChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
    const selectedValue = e.target.value;
    setFormData((prevData) => ({
      ...prevData,
      selectedDoctor: selectedValue,
    }));
  };

  const handleFormSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    console.log("Form Submitted.", formData);
    await Swal.fire({
      title: "Success!",
      html: '<p class="custom-swal-text">Your appointment request has been successfully sent.</p>',
      icon: "success",
      confirmButtonText: "Confirm",
      customClass: {
        title: "custom-swal-title",
        confirmButton: "custom-swal-confirm-button",
      },
    });

    router.push("/");

    setFormData({
      firstName: "",
      midinit: "",
      lastName: "",
      phone: 0,
      appointmentDate: undefined,
      selectedDoctor: "",
      patienceNote: "",
    });
  };

  const onNext = () => {
    if (!isCurrentStepValid()) {
      setIsButtonDisabled(true);
    }
    setCurrentIndex((prevIndex) => prevIndex + 1);
    setIsButtonDisabled(false);
  };

  const onPrevious = () => {
    setCurrentIndex((prevIndex) => prevIndex - 1);
  };

  const isCurrentStepValid = () => {
    switch (currentIndex) {
      case 0:
        return formData.firstName.trim() !== "";
      case 1:
        return formData.lastName.trim() !== "" && formData.phone !== 0;
      case 2:
        return formData.selectedDoctor.trim() !== "";
      case 3:
        return formData.appointmentDate !== undefined;
      case 4:
        return true;
      default:
        return false;
    }
  };

  const isNextButtonDisabled = () => {
    return !isCurrentStepValid();
  };

  const isSubmitButtonDisabled = () => {
    return currentIndex !== 4 || !isCurrentStepValid();
  };

  const renderStep = () => {
    switch (currentIndex) {
      case 0:
        return (
          <>
            <TextInput
              placeholder="Your First Name"
              value={formData.firstName}
              id="firstName"
              onChange={handleInputChange}
            />
            <TextInput
              placeholder="Your Middle Name (Optional)"
              value={formData.midinit}
              id="midinit"
              onChange={handleInputChange}
            />
          </>
        );
      case 1:
        return (
          <>
            <TextInput
              placeholder="Your Last Name"
              value={formData.lastName}
              id="lastName"
              onChange={handleInputChange}
            />
            <PhoneNumberInput
              placeholder="Your Phone Number (05XX XXX XX XX)"
              value={formData.phone}
              id="phone"
              onChange={(e) => handleInputChange(e as any)}
              required={true}
            />
          </>
        );
      case 2:
        return (
          <>
            <SelectComponent
              placeholder="Select the doctor you want to make an appointment with."
              value={formData.selectedDoctor}
              onChange={handleSelectChange}
              options={doctors}
            />
          </>
        );
      case 3:
        return (
          <>
            <DayPicker
              mode="single"
              selected={selected}
              onSelect={handleDateChange}
              footer={
                selected
                  ? `Selected Date: ${selected.toLocaleDateString()}`
                  : "Please choose an appointment date."
              }
            />
          </>
        );
      case 4:
        return (
          <>
            <TextArea
              placeholder="Patience Note"
              value={formData.patienceNote}
              id="patienceNote"
              onChange={handleInputChange}
            />
          </>
        );
      default:
        return null;
    }
  };

  return (
    <form className={styles.formContainer} onSubmit={handleFormSubmit}>
      {renderStep()}
      <div className={styles.buttonsWrapper}>
        {currentIndex > 0 && (
          <button type="button" onClick={onPrevious}>
            <MdArrowBack />
            Back
          </button>
        )}
        {currentIndex < 4 && (
          <button
            type="button"
            onClick={onNext}
            className={isNextButtonDisabled() ? styles.disabledButton : ""}
            disabled={isNextButtonDisabled()}
          >
            Next
            <MdArrowForward />
          </button>
        )}
        {currentIndex === 4 && (
          <button type="submit" disabled={isSubmitButtonDisabled()}>
            Submit
            <LiaClipboardCheckSolid />
          </button>
        )}
      </div>
    </form>
  );
};

export default MultistepForm;
