import axios from 'axios';
import { User } from '../features/auth/authSlice';

export interface LoginCredentials {
  username: string;
  password: string;
}

export interface RegisterCredentials {
  email: string;
  password: string;
  name: string;
  username?: string;
  telephone: string;
}

export interface OwnerRegisterCredentials {
  email: string;
  password: string;
  name: string;
  telephone: string;
}

export interface AuthResponse {
  status: string;
  token?: string;
  message?: string;
}

const API_URL = 'http://localhost:8080/api/users';
const OWNERS_API_URL = 'http://localhost:8080/api/owner';

const login = async (credentials: LoginCredentials): Promise<User> => {
  const response = await axios.post<AuthResponse>(`${API_URL}/login`, {
    email: credentials.username,
    password: credentials.password
  });
  const data = response.data;
  if (data.status === 'success' && data.token) {
    const user: User = { username: credentials.username, role: 'user', token: data.token, ...data };
    localStorage.setItem('token', data.token);
    localStorage.setItem('user', JSON.stringify(user));
    return user;
  } else {
    throw new Error(data.message || 'Login failed');
  }
};

const signup = async (credentials: RegisterCredentials): Promise<User> => {
  const response = await axios.post<AuthResponse>(`http://localhost:8080/api/customers/register`, credentials);
  const data = response.data;
  if (data.status === 'success' && data.token) {
    const user: User = { username: credentials.email, role: 'user', token: data.token, ...data };
    return user;
  } else {
    throw new Error(data.message || 'Signup failed');
  }
};

const ownerSignup = async (credentials: OwnerRegisterCredentials): Promise<User> => {
  const response = await axios.post<string>(`${OWNERS_API_URL}/register`, credentials, {
    headers: { 'Content-Type': 'application/json' }
  });
  const data: AuthResponse = JSON.parse(response.data);
  if (data.status === 'success' && data.token) {
    const user: User = { username: credentials.email, role: 'owner', token: data.token, ...data };
    localStorage.setItem('token', data.token);
    localStorage.setItem('user', JSON.stringify(user));
    return user;
  } else {
    throw new Error(data.message || 'Owner registration failed');
  }
};

const logout = (): void => {
  localStorage.removeItem('token');
  localStorage.removeItem('user');
};

export default {
  login,
  signup,
  ownerSignup,
  logout,
};
