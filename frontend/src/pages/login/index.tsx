import React, { useState } from "react";
import RootLayout from "@/layouts/RootLayout";
import styles from "./Login.module.css";
import TextInput from "@/components/input/TextInput";
import Link from "next/link";
import { useRouter } from "next/router";
import { patientApi } from "@/utils/api";
import SuccessPopup from "@/components/popup/SuccessPopup";

interface LoginFormData {
  emailAddress: string;
  password: string;
  rememberMe: boolean;
}

interface FormErrors {
  emailAddress?: string;
  password?: string;
  submit?: string;
}

const Login: React.FC = () => {
  const router = useRouter();
  const [formData, setFormData] = useState<LoginFormData>({
    emailAddress: "",
    password: "",
    rememberMe: false,
  });
  const [errors, setErrors] = useState<FormErrors>({});
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [showSuccessPopup, setShowSuccessPopup] = useState(false);

  const validateForm = (): boolean => {
    const newErrors: FormErrors = {};

    if (!formData.emailAddress) {
      newErrors.emailAddress = "Email is required";
    } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(formData.emailAddress)) {
      newErrors.emailAddress = "Please enter a valid email address";
    }

    if (!formData.password) {
      newErrors.password = "Password is required";
    } else if (formData.password.length < 8) {
      newErrors.password = "Password must be at least 8 characters long";
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value, type } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: type === 'checkbox' ? (e.target as HTMLInputElement).checked : value
    }));
    // Clear error when user starts typing
    if (errors[name as keyof FormErrors]) {
      setErrors(prev => ({
        ...prev,
        [name]: undefined
      }));
    }
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    
    if (!validateForm()) {
      return;
    }

    setIsSubmitting(true);
    try {
      const response = await patientApi.login({
        emailAddress: formData.emailAddress,
        password: formData.password,
      });

      if (response.code === 0) {
        setShowSuccessPopup(true);
        // Store remember me preference if needed
        if (formData.rememberMe) {
          localStorage.setItem('rememberMe', 'true');
        }
        // Redirect to home page after 2 seconds
        setTimeout(() => {
          router.push('/');
        }, 2000);
      } else {
        setErrors({
          submit: response.message || "Login failed. Please try again."
        });
      }
    } catch (error) {
      setErrors({
        submit: "An error occurred. Please try again later."
      });
    } finally {
      setIsSubmitting(false);
    }
  };

  return (
    <RootLayout>
      <section className={styles.loginSection}>
        <div className="container">
          <div className={styles.loginContainer}>
            <h1 className={styles.loginTitle}>Login</h1>
            <p className={styles.loginSubtitle}>
              Please enter your credentials to access your account
            </p>

            <form onSubmit={handleSubmit} className={styles.loginForm}>
              <div className={styles.inputWrapper}>
                <TextInput
                  label="Email Address"
                  name="emailAddress"
                  type="email"
                  value={formData.emailAddress}
                  onChange={handleInputChange}
                  error={errors.emailAddress}
                />
              </div>

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

              <div className={styles.formOptions}>
                <label className={styles.rememberMe}>
                  <input 
                    type="checkbox" 
                    name="rememberMe"
                    checked={formData.rememberMe}
                    onChange={handleInputChange}
                  />
                  <span>Remember me</span>
                </label>
                <Link href="/forgot-password" className={styles.forgotPassword}>
                  Forgot Password?
                </Link>
              </div>

              <button 
                type="submit" 
                className={`${styles.loginButton} ${isSubmitting ? styles.loading : ''}`}
                disabled={isSubmitting}
              >
                {isSubmitting ? 'Logging in...' : 'Login'}
              </button>

              {errors.submit && (
                <span className={styles.errorMessage}>{errors.submit}</span>
              )}

              <div className={styles.registerLink}>
                <p>
                  Don't have an account?{" "}
                  <Link href="/register">Register here</Link>
                </p>
              </div>
            </form>
          </div>
        </div>
      </section>

      {showSuccessPopup && (
        <SuccessPopup
          message="Login successful! Redirecting..."
          onClose={() => setShowSuccessPopup(false)}
        />
      )}
    </RootLayout>
  );
};

export default Login; 