import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, RootState } from "../../store/store";
import { ownerSignup } from "../../features/auth/authSlice";
import { Navigate } from "react-router-dom";
import styles from "../../assets/styles/AuthForm.module.css";

interface AdminCredentials {
  email: string;
  password: string;
  name: string;
  telephone: string;
  confirmPassword: string;
}

const AdminSignupForm: React.FC = () => {
  const dispatch = useDispatch<AppDispatch>();
  const { isAuthenticated, loading, error } = useSelector(
    (state: RootState) => state.auth
  );
  const [credentials, setCredentials] = useState<AdminCredentials>({
    email: "",
    password: "",
    name: "",
    telephone: "",
    confirmPassword: ""
  });
  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setCredentials({ ...credentials, [e.target.name]: e.target.value });
  };
  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    if (credentials.password !== credentials.confirmPassword) {
      alert("Passwords do not match!");
      return;
  }
    dispatch(ownerSignup(credentials));
  };
  if (isAuthenticated) {
    return <Navigate to="/" />;
  }
  return (
    <div className={styles["auth-container"]}>
      <form onSubmit={handleSubmit} className={styles["auth-card"]}>
        <h2>Owner Signup</h2>
        <input
          type="text"
          name="name"
          placeholder="Name"
          onChange={handleChange}
          value={credentials.name}
          required
          className={styles["auth-input"]}
        />
        <input
          type="text"
          name="email"
          placeholder="Email"
          onChange={handleChange}
          value={credentials.email}
          required
          className={styles["auth-input"]}
        />
        <input
          type="text"
          name="telephone"
          placeholder="Telephone"
          onChange={handleChange}
          value={credentials.telephone}
          required
          className={styles["auth-input"]}
        />
        <input
          type="password"
          name="password"
          placeholder="Password"
          onChange={handleChange}
          value={credentials.password}
          required
          className={styles["auth-input"]}
        />
        <input
          type="password"
          name="confirmPassword"
          placeholder="Confirm Password"
          onChange={handleChange}
          value={credentials.confirmPassword}
          required
          className={styles["auth-input"]}
        />
        <button
          type="submit"
          disabled={loading}
          className={styles["auth-button"]}
        >
          {loading ? "Signing up..." : "Sign Up"}
        </button>
        {error && <p className="error-message">{error}</p>}
        <div className={styles["auth-footer"]}>
          <span>
            Already have an account? <a href="/login">Login</a>
          </span>
        </div>
      </form>
    </div>
  );
};

export default AdminSignupForm;
