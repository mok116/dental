import React, { useState, useEffect } from "react";
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
import { patientApi } from "@/utils/api";

interface FormData {
  firstName: string;
  midinit: string;
  lastName: string;
  phone: number;
  appointmentDate: Date | undefined;
  selectedDoctor: string;
  selectedTreatment: string;
  selectedClinic: string;
  selectedTimeSlot: string;
  patienceNote: string;
}

interface Treatment {
  id: number;
  name: string;
  image_url: string;
}

interface DentistItem {
  id: number;
  dentistReferenceId: number;
  dentist: {
    id: number;
    firstName: string;
    lastName: string;
    gender: string;
    emailAddress: string;
    imageUrl?: string;
  };
  itemReferenceId: number;
  item: {
    id: number;
    name: string;
  };
  fee: number;
}

interface ClinicDentist {
  id: number;
  clinicReferenceId: number;
  clinic: {
    id: number;
    name: string;
    address: string;
    district: string;
    phone: string;
    openHours: string;
  };
  dentistReferenceId: number;
  dentist: {
    id: number;
    firstName: string;
    lastName: string;
    gender: string;
    emailAddress: string;
    imageUrl?: string;
  };
  dayOfWeek: string;
  timeslotReferenceId: number;
  timeslot: {
    id: number;
    startTime: string;
    endTime: string;
  };
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
    selectedTreatment: "",
    selectedClinic: "",
    selectedTimeSlot: "",
    patienceNote: "",
  });
  
  const [treatments, setTreatments] = useState<Treatment[]>([]);
  const [dentistItems, setDentistItems] = useState<DentistItem[]>([]);
  const [clinicDentists, setClinicDentists] = useState<ClinicDentist[]>([]);
  const [availableTimeSlots, setAvailableTimeSlots] = useState<{id: number, startTime: string, endTime: string}[]>([]);
  const [selected, setSelected] = useState<Date | undefined>(undefined);
  const [isButtonDisabled, setIsButtonDisabled] = useState<boolean>(true);

  useEffect(() => {
    const fetchTreatments = async () => {
      try {
        const response = await patientApi.getTreatments();
        if (response.code === 0) {
          setTreatments(response.itemList);
        }
      } catch (error) {
        console.error("Error fetching treatments:", error);
      }
    };

    fetchTreatments();
  }, []);

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
    
    // If we already have dentist and clinic selected, update time slots
    if (date && formData.selectedDoctor && formData.selectedClinic) {
      updateAvailableTimeSlots();
    }
  };

  const handleSelectChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
    const { id, value } = e.target;
    
    setFormData((prevData) => ({
      ...prevData,
      [id]: value,
    }));

    // If treatment is selected, fetch dentists for that treatment
    if (id === "selectedTreatment" && value) {
      fetchDentistsByTreatment(parseInt(value));
    }
    
    // If dentist is selected, fetch clinics for that dentist
    if (id === "selectedDoctor" && value) {
      fetchClinicsByDentist(parseInt(value));
    }
    
    // If clinic is selected, update available time slots
    if (id === "selectedClinic" && value && formData.selectedDoctor && formData.appointmentDate) {
      updateAvailableTimeSlots();
    }
    
    // If time slot is selected, update form data
    if (id === "selectedTimeSlot") {
      setFormData((prevData) => ({
        ...prevData,
        selectedTimeSlot: value,
      }));
    }
  };

  const fetchDentistsByTreatment = async (treatmentId: number) => {
    try {
      const response = await fetch(`http://localhost:6616/dentistItem/item/${treatmentId}`);
      const data = await response.json();
      if (data.code === 0) {
        setDentistItems(data.dentistItemList);
      } else {
        console.error("Error fetching dentists:", data.message);
      }
    } catch (error) {
      console.error("Error fetching dentists:", error);
    }
  };

  const fetchClinicsByDentist = async (dentistId: number) => {
    try {
      const response = await fetch(`http://localhost:6616/clinicDentist/dentist/${dentistId}`);
      const data = await response.json();
      if (data.code === 0) {
        setClinicDentists(data.clinicDentistList);
      } else {
        console.error("Error fetching clinics:", data.message);
      }
    } catch (error) {
      console.error("Error fetching clinics:", error);
    }
  };
  
  const updateAvailableTimeSlots = () => {
    if (!formData.appointmentDate || !formData.selectedDoctor || !formData.selectedClinic) {
      setAvailableTimeSlots([]);
      return;
    }
    
    // Get day of week from selected date
    const daysOfWeek = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
    const dayOfWeek = daysOfWeek[formData.appointmentDate.getDay()];
    
    // Filter clinic dentists by selected dentist, clinic, and day of week
    const filteredSlots = clinicDentists.filter(item => 
      item.dentist.id.toString() === formData.selectedDoctor &&
      item.clinic.id.toString() === formData.selectedClinic &&
      item.dayOfWeek === dayOfWeek
    );
    
    // Extract time slots
    const slots = filteredSlots.map(item => ({
      id: item.timeslot.id,
      startTime: item.timeslot.startTime,
      endTime: item.timeslot.endTime
    }));
    
    setAvailableTimeSlots(slots);
    
    // Reset selected time slot
    setFormData(prevData => ({
      ...prevData,
      selectedTimeSlot: ""
    }));
  };

  const handleFormSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    
    const jwtToken = sessionStorage.getItem('jwtToken');
    const patientInfo = sessionStorage.getItem('patientInfo');

    if (!jwtToken || !patientInfo) {
      await Swal.fire({
        title: "Error!",
        html: '<p class="custom-swal-text">Please login first.</p>',
        icon: "error",
        confirmButtonText: "OK",
      });
      router.push("/login");
      return;
    }

    const selectedDentistItem = dentistItems.find(d => d.dentist.id.toString() === formData.selectedDoctor);
    const selectedClinicDentist = clinicDentists.find(cd => 
      cd.clinic.id.toString() === formData.selectedClinic &&
      cd.timeslot.id.toString() === formData.selectedTimeSlot
    );

    if (!selectedDentistItem || !selectedClinicDentist || !formData.appointmentDate) {
      await Swal.fire({
        title: "Error!",
        html: '<p class="custom-swal-text">Invalid appointment data.</p>',
        icon: "error",
        confirmButtonText: "OK",
      });
      return;
    }

    try {
      const parsedPatientInfo = JSON.parse(patientInfo);
      const appointmentData = {
        patientId: parsedPatientInfo.id,
        clinicDentistId: selectedClinicDentist.id,
        appointmentDate: formData.appointmentDate.toISOString().split('T')[0] + 'T10:00:00',
        totalAmount: selectedDentistItem.fee,
        status: "PENDING",
        appointmentItems: [
          {
            id: 0,
            dentistItemId: selectedDentistItem.id
          }
        ]
      };

      const response = await patientApi.submitAppointment(appointmentData);

      if (response.code === 0) {
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
          selectedTreatment: "",
          selectedClinic: "",
          selectedTimeSlot: "",
          patienceNote: "",
        });
      } else {
        throw new Error(response.message || 'Failed to create appointment');
      }
    } catch (error) {
      console.error('Error creating appointment:', error);
      await Swal.fire({
        title: "Error!",
        html: '<p class="custom-swal-text">Failed to create appointment. Please try again.</p>',
        icon: "error",
        confirmButtonText: "OK",
      });
    }
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
        return formData.selectedTreatment.trim() !== "";
      case 1:
        // Validate that a date is selected and it's not in the past
        if (!formData.appointmentDate) return false;
        const today = new Date();
        today.setHours(0, 0, 0, 0); // Reset time to start of day for proper comparison
        return formData.appointmentDate >= today;
      case 2:
        return formData.selectedDoctor.trim() !== "";
      case 3:
        return formData.selectedTimeSlot.trim() !== "";
      case 4:
        return true; // Patient note is optional
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
            <h2 className={styles.stepTitle}>Select Treatment</h2>
            <SelectComponent
              placeholder="Select the treatment you need"
              value={formData.selectedTreatment}
              id="selectedTreatment"
              onChange={handleSelectChange}
              options={treatments.map(treatment => ({
                value: treatment.id.toString(),
                label: treatment.name
              }))}
            />
          </>
        );
      case 1:
        return (
          <>
            <h2 className={styles.stepTitle}>Choose Appointment Date</h2>
            <DayPicker
              mode="single"
              selected={selected}
              onSelect={handleDateChange}
              disabled={[{ before: new Date() }]}
              footer={
                selected
                  ? `Selected Date: ${selected.toLocaleDateString()}`
                  : "Please choose an appointment date. Past dates are disabled."
              }
            />
          </>
        );
      case 2:
        return (
          <>
            <h2 className={styles.stepTitle}>Select Your Dentist</h2>
            <SelectComponent
              placeholder="Select your dentist"
              value={formData.selectedDoctor}
              id="selectedDoctor"
              onChange={handleSelectChange}
              options={dentistItems.map(item => ({
                value: item.dentist.id.toString(),
                label: `${item.dentist.firstName} ${item.dentist.lastName}`
              }))}
            />
          </>
        );
      case 3:
        return (
          
          <div className={styles.clinicTimeSlots}>
            {clinicDentists
              .filter((item, index, self) => 
                index === self.findIndex(t => t.clinic.id === item.clinic.id)
              )
              .map(clinic => {
                const clinicTimeSlots = clinicDentists.filter(cd => 
                  cd.clinic.id === clinic.clinic.id && 
                  cd.dentist.id.toString() === formData.selectedDoctor &&
                  cd.dayOfWeek === selected?.toLocaleDateString('en-US', { weekday: 'short' })
                );
                
                return (
                  <div key={clinic.clinic.id} className={styles.clinicCard}>
                    <h3>{clinic.clinic.name}</h3>
                    <p>{clinic.clinic.address}</p>
                    <div className={styles.timeSlotButtons}>
                      {clinicTimeSlots.map(slot => (
                        <button
                          key={slot.timeslot.id}
                          type="button"
                          className={`${styles.timeSlotButton} ${
                            formData.selectedTimeSlot === slot.timeslot.id.toString() &&
                            formData.selectedClinic === clinic.clinic.id.toString()
                              ? styles.selected
                              : ''
                          }`}
                          onClick={() => {
                            setFormData(prev => ({
                              ...prev,
                              selectedClinic: clinic.clinic.id.toString(),
                              selectedTimeSlot: slot.timeslot.id.toString()
                            }));
                          }}
                        >
                          {slot.timeslot.startTime.substring(0, 5)} - {slot.timeslot.endTime.substring(0, 5)}
                        </button>
                      ))}
                      {clinicTimeSlots.length === 0 && (
                        <p className={styles.noTimeSlotsMessage}>
                          No available time slots at this clinic for the selected date.
                        </p>
                      )}
                    </div>
                  </div>
                );
              })}
          </div>
        );
      case 4:
        const selectedTreatment = treatments.find(t => t.id.toString() === formData.selectedTreatment);
        const selectedDentistItem = dentistItems.find(d => d.dentist.id.toString() === formData.selectedDoctor);
        const selectedClinicInfo = clinicDentists.find(cd => cd.clinic.id.toString() === formData.selectedClinic);
        const selectedTimeSlotInfo = clinicDentists.find(cd => cd.timeslot.id.toString() === formData.selectedTimeSlot);

        return (
          <div className={styles.appointmentSummary}>
            <h2 className={styles.stepTitle}>Appointment Summary</h2>
            <div className={styles.summaryCard}>
              <div className={styles.summaryItem}>
                <strong>Treatment:</strong>
                <span>{selectedTreatment?.name}</span>
              </div>
              <div className={styles.summaryItem}>
                <strong>Dentist:</strong>
                <span>
                  {selectedDentistItem?.dentist.gender === 'M' ? 'Dr.' : 'Dr.'} {selectedDentistItem?.dentist.firstName} {selectedDentistItem?.dentist.lastName}
                </span>
              </div>
              <div className={styles.summaryItem}>
                <strong>Date:</strong>
                <span>{formData.appointmentDate?.toLocaleDateString()}</span>
              </div>
              <div className={styles.summaryItem}>
                <strong>Time:</strong>
                <span>
                  {selectedTimeSlotInfo?.timeslot.startTime.substring(0, 5)} - {selectedTimeSlotInfo?.timeslot.endTime.substring(0, 5)}
                </span>
              </div>
              <div className={styles.summaryItem}>
                <strong>Clinic:</strong>
                <span>
                  {selectedClinicInfo?.clinic.name}<br />
                  {selectedClinicInfo?.clinic.address}
                </span>
              </div>
              <div className={styles.summaryItem}>
                <strong>Fee:</strong>
                <span>${selectedDentistItem?.fee.toFixed(2)}</span>
              </div>
            </div>
          </div>
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
