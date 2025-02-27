import React from 'react';
import SignupForm from '../components/Auth/SignupForm';
import styles from '../assets/styles/AuthPage.module.css';

const Signup: React.FC = () => {
    return (
        <div className={styles.container}>
            <SignupForm />
        </div>
    );
};

export default Signup;
