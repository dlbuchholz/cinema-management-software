import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { AppDispatch, RootState } from '../../store/store';
import { login } from '../../features/auth/authSlice';
import { Navigate } from 'react-router-dom';
import styles from '../../assets/styles/AuthForm.module.css';

interface Credentials {
    username: string;
    password: string;
}

const LoginForm: React.FC = () => {
    const dispatch = useDispatch<AppDispatch>();
    const { isAuthenticated, loading, error } = useSelector((state: RootState) => state.auth);

    const [credentials, setCredentials] = useState<Credentials>({
        username: '',
        password: ''
    });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setCredentials({ ...credentials, [e.target.name]: e.target.value });
    };

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        dispatch(login(credentials));
    };

    if (isAuthenticated) {
        return <Navigate to="/" />;
    }

    return (
        <div className={styles['auth-container']}>
            <form onSubmit={handleSubmit} className={styles['auth-card']}>
                <h2>Sign in with Email</h2>
                <p>Access your account and manage cinemas efficiently.</p>
                <input
                    type="text"
                    name="username"
                    placeholder="Username"
                    onChange={handleChange}
                    value={credentials.username}
                    required
                    className={styles['auth-input']}
                />
                <input
                    type="password"
                    name="password"
                    placeholder="Password"
                    onChange={handleChange}
                    value={credentials.password}
                    required
                    className={styles['auth-input']}
                />
                <button type="submit" disabled={loading} className={styles['auth-button']}>
                    {loading ? 'Logging in...' : 'Login'}
                </button>
                {error && <p className="error-message">{error}</p>}
                <div className={styles['auth-footer']}>
                    <span>Don't have an account? <a href="/signup">Sign Up</a></span>
                </div>
            </form>
        </div>
    );
};

export default LoginForm;
