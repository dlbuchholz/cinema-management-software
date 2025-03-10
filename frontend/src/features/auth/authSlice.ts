// src/features/auth/authSlice.ts

import { createSlice, createAsyncThunk, PayloadAction } from '@reduxjs/toolkit';
import authService from '../../services/authService';

// --- Define separate interfaces for login and registration credentials ---

export interface LoginCredentials {
  email: string;
  password: string;
}

export interface RegisterCredentials {
  email: string;
  password: string;
  name: string;
  telephone: string;
}

// --- User interface returned on success ---
export interface User {
  username: string;
  role: string;
  token: string;
}

// --- AuthResponse interface from server ---
export interface AuthResponse {
  status: string;
  token?: string;
  message?: string;
}

// --- Auth State ---
interface AuthState {
  user: User | null;
  isAuthenticated: boolean;
  loading: boolean;
  success: boolean;
  error: string | null;
}

const user = JSON.parse(localStorage.getItem('user') || 'null');

// --- Initial State ---
const initialState: AuthState = {
  user: user,
  isAuthenticated: !!user,
  loading: false,
  success: false,
  error: null
};

// --- Async Thunk for Login ---
export const login = createAsyncThunk<
  User,
  LoginCredentials,
  { rejectValue: string }
>(
  'auth/login',
  async (credentials, thunkAPI) => {
    try {
      // Fake admin login check: only accept email "admin" and password "admin"
      if (credentials.email === 'admin' && credentials.password === 'admin') {
        const fakeAdmin: User = { username: 'admin', role: 'admin', token: 'fake-admin-token' };
        return fakeAdmin;
      }
      // Otherwise, call the real login endpoint
      const userData = await authService.login(credentials);
      return userData;
    } catch (error: any) {
      return thunkAPI.rejectWithValue(error.response?.data?.message || 'Login failed');
    }
  }
);

export const signup = createAsyncThunk<
  User,
  RegisterCredentials,
  { rejectValue: string }
>(
  'auth/signup',
  async (credentials, thunkAPI) => {
    try {
      const response = await authService.signup(credentials);

      // Check if server returned an error status
      if (response.status === 'error') {
        // Return the server's message as a rejected value
        return thunkAPI.rejectWithValue(response.message || 'Signup failed');
      }

      // Otherwise, success
      return response; // This is the User object
    } catch (error: any) {
      return thunkAPI.rejectWithValue(
        error.response?.data?.message || 'Signup failed'
      );
    }
  }
);


// --- Auth Slice ---
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
    // Login Cases
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
      // Signup Cases
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
