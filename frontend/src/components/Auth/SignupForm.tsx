import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { AppDispatch, RootState } from '../../store/store';
import { Navigate } from 'react-router-dom';
import styles from '../../assets/styles/AuthForm.module.css';
import { signup } from '../../features/auth/authSlice';

interface SignupData {
    username: string;
    password: string;
    confirmPassword: string;
}

const SignupForm: React.FC = () => {
    const dispatch = useDispatch<AppDispatch>();
    const { isAuthenticated, loading, error } = useSelector((state: RootState) => state.auth);

    const [signupData, setSignupData] = useState<SignupData>({
        username: '',
        password: '',
        confirmPassword: ''
    });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setSignupData({ ...signupData, [e.target.name]: e.target.value });
    };

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        if (signupData.password !== signupData.confirmPassword) {
            alert("Passwords do not match!");
            return;
        }
        dispatch(signup({ username: signupData.username, password: signupData.password }));
    };

    if (isAuthenticated) {
        return <Navigate to="/" />;
    }

    return (
        <div className={styles['auth-container']}>
            <form onSubmit={handleSubmit} className={styles['auth-card']}>
                <h2>Create Account</h2>
                <p>Start managing your cinemas with ease.</p>
                <input
                    type="text"
                    name="username"
                    placeholder="Username"
                    onChange={handleChange}
                    value={signupData.username}
                    required
                    className={styles['auth-input']}
                />
                <input
                    type="password"
                    name="password"
                    placeholder="Password"
                    onChange={handleChange}
                    value={signupData.password}
                    required
                    className={styles['auth-input']}
                />
                <input
                    type="password"
                    name="confirmPassword"
                    placeholder="Confirm Password"
                    onChange={handleChange}
                    value={signupData.confirmPassword}
                    required
                    className={styles['auth-input']}
                />
                <button type="submit" disabled={loading} className={styles['auth-button']}>
                    {loading ? 'Creating Account...' : 'Register'}
                </button>
                {error && <p className="error-message">{error}</p>}
                <div className={styles['auth-footer']}>
                    <span>Already have an account? <a href="/login">Sign In</a></span>
                </div>
            </form>
        </div>
    );
};

export default SignupForm;
