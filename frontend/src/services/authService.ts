// src/services/authService.ts

import axios from 'axios';

/**
 * Interface for login credentials.
 */
export interface LoginCredentials {
  email: string;
  username: string;
  password: string;
}

/**
 * Interface for registration credentials.
 */
export interface RegisterCredentials {
  email: string;
  password: string;
  name: string;
  username?: string;
  telephone: string;
}

/**
 * Interface for the authentication response from the server.
 */
export interface AuthResponse {
  status: string;
  token?: string;
  message?: string;
}

const API_URL = 'http://localhost:8080/api/customers';

/**
 * Sends login credentials to the server and saves the token if login is successful.
 */
const login = async (credentials: LoginCredentials): Promise<AuthResponse> => {
  const response = await axios.post<AuthResponse>(`${API_URL}/login`, {
    email: credentials.username,
    password: credentials.password
  });
  const data = response.data;
  if (data.status === 'success' && data.token) {
    localStorage.setItem('token', data.token);
  }
  return data;
};

/**
 * Sends registration data to the server and saves the token if registration is successful.
 */
const signup = async (credentials: RegisterCredentials): Promise<AuthResponse> => {
  const response = await axios.post<AuthResponse>(`${API_URL}/register`, credentials);
  const data = response.data;
  if (data.status === 'success' && data.token) {
    localStorage.setItem('user', JSON.stringify(data.token));
    localStorage.setItem('token', data.token);
  }
  return data;
};

/**
 * Clears the token from localStorage.
 */
const logout = (): void => {
  localStorage.removeItem('token');
  localStorage.removeItem('user');
};

export default {
  login,
  signup,
  logout,
};
