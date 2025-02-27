import { createSlice, createAsyncThunk, PayloadAction } from '@reduxjs/toolkit';
import authService from '../../services/authService';

export interface Credentials {
    username: string;
    password: string;
}

export interface User {
    username: string;
    role: string;
    token: string;
}

interface AuthState {
    user: User | null;
    isAuthenticated: boolean;
    loading: boolean;
    success: boolean;
    error: string | null;
}

const user = JSON.parse(localStorage.getItem('user') || 'null');

// 🔹 Initial State
const initialState: AuthState = {
    user: user,
    isAuthenticated: !!user,
    loading: false,
    success: false,
    error: null
};

export const login = createAsyncThunk<
    User,                       
    Credentials,             
    { rejectValue: string }   
>(
    'auth/login',
    async (credentials, thunkAPI) => {
        try {
            const userData = await authService.login(credentials);
            return userData;
        } catch (error: any) {
            return thunkAPI.rejectWithValue(error.response.data.message || 'Login failed');
        }
    }
);

export const signup = createAsyncThunk<
    User,
    Credentials,
    { rejectValue: string }
>(
    'auth/signup',
    async (userData, thunkAPI) => {
        try {
            const response = await authService.signup(userData);
            return response;
        } catch (error: any) {
            return thunkAPI.rejectWithValue(error.response.data.message || 'Signup failed');
        }
    }
);

const authSlice = createSlice({
    name: 'auth',
    initialState,
    reducers: {
        logout: (state) => {
            localStorage.removeItem('user');
            state.user = null;
            state.isAuthenticated = false;
            state.loading = false;
            state.success = false;
            state.error = null;
        }
    },
    extraReducers: (builder) => {
        builder
            .addCase(login.pending, (state) => {
                state.loading = true;
                state.success = false;
                state.error = null;
            })
            .addCase(login.fulfilled, (state, action: PayloadAction<User>) => {
                state.loading = false;
                state.user = action.payload;
                state.isAuthenticated = true;
                state.success = true;
                state.error = null;
                localStorage.setItem('user', JSON.stringify(action.payload));
            })
            .addCase(login.rejected, (state, action) => {
                state.loading = false;
                state.error = action.payload as string;
                state.success = false;
            })
            .addCase(signup.pending, (state) => {
                state.loading = true;
                state.success = false;
                state.error = null;
            })
            .addCase(signup.fulfilled, (state, action: PayloadAction<User>) => {
                state.loading = false;
                state.user = action.payload;
                state.isAuthenticated = true;
                state.success = true;
                state.error = null;
                localStorage.setItem('user', JSON.stringify(action.payload));
            })
            .addCase(signup.rejected, (state, action) => {
                state.loading = false;
                state.error = action.payload as string;
                state.success = false;
            });
    }
});

export const { logout } = authSlice.actions;
export default authSlice.reducer;
