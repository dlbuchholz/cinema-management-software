import React from 'react';

interface ButtonProps {
    children: React.ReactNode;
    onClick?: () => void;
    type?: 'button' | 'submit' | 'reset';
    disabled?: boolean;
}

const Button: React.FC<ButtonProps> = ({ 
    children, 
    onClick, 
    type = 'button', 
    disabled = false 
}) => {
    return (
        <button 
            type={type} 
            onClick={onClick} 
            disabled={disabled} 
            className="custom-button"
        >
            {children}
        </button>
    );
};

export default Button;
