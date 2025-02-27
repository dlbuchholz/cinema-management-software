import React from 'react';
import LoginForm from '../components/Auth/LoginForm';
import styles from '../assets/styles/AuthPage.module.css';

const Login: React.FC = () => {
    return (
        <div className={styles.container}>
            <LoginForm />
        </div>
    );
};

export default Login;
