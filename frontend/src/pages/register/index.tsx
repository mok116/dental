import React, { useState } from "react";
import RootLayout from "@/layouts/RootLayout";
import TextInput from "@/components/input/TextInput";
import Link from "next/link";
import { useRouter } from "next/router";
import { patientApi } from "@/utils/api";
import SuccessPopup from "@/components/popup/SuccessPopup";
import styles from "./Register.module.css";

interface RegisterFormData {
  firstName: string;
  lastName: string;
  emailAddress: string;
  gender: "M" | "F";
  dob: string;
  phone: string;
  password: string;
  confirmPassword: string;
  agreeToTerms: boolean;
}

interface FormErrors {
  firstName?: string;
  lastName?: string;
  emailAddress?: string;
  gender?: string;
  dob?: string;
  phone?: string;
  password?: string;
  confirmPassword?: string;
  agreeToTerms?: string;
  submit?: string;
}

const Register: React.FC = () => {
  const router = useRouter();
  const [formData, setFormData] = useState<RegisterFormData>({
    firstName: "",
    lastName: "",
    emailAddress: "",
    gender: "M",
    dob: "",
    phone: "",
    password: "",
    confirmPassword: "",
    agreeToTerms: false,
  });

  const [errors, setErrors] = useState<FormErrors>({});
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [showSuccessPopup, setShowSuccessPopup] = useState(false);

  const validateForm = (): boolean => {
    const newErrors: FormErrors = {};

    if (!formData.firstName) {
      newErrors.firstName = "First name is required";
    }

    if (!formData.lastName) {
      newErrors.lastName = "Last name is required";
    }

    if (!formData.emailAddress) {
      newErrors.emailAddress = "Email is required";
    } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(formData.emailAddress)) {
      newErrors.emailAddress = "Please enter a valid email address";
    }

    if (!formData.gender) {
      newErrors.gender = "Gender is required";
    }

    if (!formData.dob) {
      newErrors.dob = "Date of birth is required";
    }

    if (!formData.phone) {
      newErrors.phone = "Phone number is required";
    } else if (!/^\+?[1-9]\d{1,14}$/.test(formData.phone)) {
      newErrors.phone = "Please enter a valid phone number";
    }

    if (!formData.password) {
      newErrors.password = "Password is required";
    } else if (formData.password.length < 8) {
      newErrors.password = "Password must be at least 8 characters long";
    }

    if (!formData.confirmPassword) {
      newErrors.confirmPassword = "Please confirm your password";
    } else if (formData.password !== formData.confirmPassword) {
      newErrors.confirmPassword = "Passwords do not match";
    }

    if (!formData.agreeToTerms) {
      newErrors.agreeToTerms = "You must agree to the terms and conditions";
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleInputChange = (
    e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>
  ) => {
    const { name, value, type } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: type === "checkbox" ? (e.target as HTMLInputElement).checked : value,
    }));
    // Clear error when user starts typing
    if (errors[name as keyof FormErrors]) {
      setErrors((prev) => ({ ...prev, [name]: undefined }));
    }
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();

    if (!validateForm()) {
      return;
    }

    setIsSubmitting(true);

    try {
      const response = await patientApi.register({
        firstName: formData.firstName,
        lastName: formData.lastName,
        emailAddress: formData.emailAddress,
        gender: formData.gender,
        dob: formData.dob ? `${formData.dob}T10:00:00` : "",
        phone: formData.phone,
        password: formData.password,
      });

      if (response.code === 0) {
        setShowSuccessPopup(true);
        // Redirect to login page after 2 seconds
        setTimeout(() => {
          router.push("/login");
        }, 2000);
      } else {
        setErrors({
          submit: response.message || "Registration failed. Please try again.",
        });
      }
    } catch (error) {
      setErrors({
        submit: "An error occurred. Please try again later.",
      });
    } finally {
      setIsSubmitting(false);
    }
  };

  return (
    <RootLayout>
      <div className={styles.registerSection}>
        <div className={styles.registerContainer}>
          <h2 className={styles.registerTitle}>Create Account</h2>
          <p className={styles.registerSubtitle}>
            Join our dental clinic community
          </p>

          <form onSubmit={handleSubmit} className={styles.registerForm}>
            <div className={styles.formRow}>
              <div className={styles.inputWrapper}>
                <TextInput
                  label="First Name"
                  name="firstName"
                  value={formData.firstName}
                  onChange={handleInputChange}
                  error={errors.firstName}
                />
              </div>
              <div className={styles.inputWrapper}>
                <TextInput
                  label="Last Name"
                  name="lastName"
                  value={formData.lastName}
                  onChange={handleInputChange}
                  error={errors.lastName}
                />
              </div>
            </div>

            <div className={styles.inputWrapper}>
              <TextInput
                label="Email"
                name="emailAddress"
                type="email"
                value={formData.emailAddress}
                onChange={handleInputChange}
                error={errors.emailAddress}
              />
            </div>

            <div className={styles.formRow}>
              <div className={styles.inputWrapper}>
                <label>Gender</label>
                <select
                  name="gender"
                  value={formData.gender}
                  onChange={handleInputChange}
                  className={styles.select}
                >
                  <option value="M">Male</option>
                  <option value="F">Female</option>
                </select>
                {errors.gender && (
                  <span className={styles.errorMessage}>{errors.gender}</span>
                )}
              </div>
              <div className={styles.inputWrapper}>
                <TextInput
                  label="Date of Birth"
                  name="dob"
                  type="date"
                  value={formData.dob}
                  onChange={handleInputChange}
                  error={errors.dob}
                />
              </div>
            </div>

            <div className={styles.inputWrapper}>
              <TextInput
                label="Phone Number"
                name="phone"
                type="tel"
                value={formData.phone}
                onChange={handleInputChange}
                error={errors.phone}
                placeholder="Example: 45678900"
              />
            </div>

            <div className={styles.formRow}>
              <div className={styles.inputWrapper}>
                <TextInput
                  label="Password"
                  name="password"
                  type="password"
                  value={formData.password}
                  onChange={handleInputChange}
                  error={errors.password}
                />
              </div>
              <div className={styles.inputWrapper}>
                <TextInput
                  label="Confirm Password"
                  name="confirmPassword"
                  type="password"
                  value={formData.confirmPassword}
                  onChange={handleInputChange}
                  error={errors.confirmPassword}
                />
              </div>
            </div>

            <div className={styles.termsWrapper}>
              <label className={styles.termsCheckbox}>
                <input
                  type="checkbox"
                  name="agreeToTerms"
                  checked={formData.agreeToTerms}
                  onChange={handleInputChange}
                />
                I agree to the{" "}
                <Link href="/terms" className={styles.termsLink}>
                  Terms and Conditions
                </Link>
              </label>
              {errors.agreeToTerms && (
                <span className={styles.errorMessage}>
                  {errors.agreeToTerms}
                </span>
              )}
            </div>

            <button
              type="submit"
              className={`${styles.registerButton} ${
                isSubmitting ? styles.loading : ""
              }`}
              disabled={isSubmitting}
            >
              {isSubmitting ? "Creating Account..." : "Create Account"}
            </button>

            {errors.submit && (
              <span className={styles.errorMessage}>{errors.submit}</span>
            )}
          </form>

          <p className={styles.loginLink}>
            Already have an account?{" "}
            <Link href="/login">Sign in</Link>
          </p>
        </div>
      </div>

      {showSuccessPopup && (
        <SuccessPopup
          message="Account created successfully! Redirecting to login..."
          onClose={() => setShowSuccessPopup(false)}
        />
      )}
    </RootLayout>
  );
};

export default Register;