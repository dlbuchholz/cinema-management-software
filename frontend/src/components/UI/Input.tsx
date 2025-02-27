import React from 'react';

interface InputProps {
    name: string;
    type?: string;
    placeholder?: string;
    value?: string;
    onChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
    required?: boolean;
}

const Input: React.FC<InputProps> = ({ 
    name, 
    type = 'text', 
    placeholder, 
    value, 
    onChange, 
    required = false 
}) => {
    return (
        <input 
            type={type} 
            name={name} 
            placeholder={placeholder} 
            value={value} 
            onChange={onChange} 
            required={required}
            className="custom-input"
        />
    );
};

export default Input;
