import axios from 'axios';

interface Credentials {
    username: string;
    password: string;
}

interface User {
    username: string;
    role: string;
    token: string;
}

const API_URL = 'http://localhost:8080/api/auth';

const login = async (credentials: Credentials): Promise<User> => {
    const response = await axios.post(`${API_URL}/login`, credentials);
    return response.data;
};

const signup = async (userData: Credentials): Promise<User> => {
    const response = await axios.post(`${API_URL}/signup`, userData);
    return response.data;
};

export default {
    login,
    signup
};
