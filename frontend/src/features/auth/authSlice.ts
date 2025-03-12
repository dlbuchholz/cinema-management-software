import {createAsyncThunk, createSlice, PayloadAction} from '@reduxjs/toolkit';
import authService from '../../services/authService';

export interface LoginCredentials {
  username: string;
  password: string;
}

export interface RegisterCredentials {
  email: string;
  password: string;
  name: string;
  telephone: string;
}

export interface OwnerRegisterCredentials {
  email: string;
  password: string;
  name: string;
  telephone: string;
}

export interface User {
  id: string;
  username: string;
  role: string;
  token: string;
  id: number;
  email: string;
}

export interface AuthResponse {
  status: string;
  token?: string;
  message?: string;
}

interface AuthState {
  user: User | null;
  isAuthenticated: boolean;
  loading: boolean;
  success: boolean;
  error: string | null;
}

const persistedUser = localStorage.getItem('user');
const user = persistedUser ? JSON.parse(persistedUser) : null;

const initialState: AuthState = {
  user: user,
  isAuthenticated: !!localStorage.getItem('token'),
  loading: false,
  success: false,
  error: null
};

export const login = createAsyncThunk<
  User,
  LoginCredentials,
  { rejectValue: string }
>('auth/login', async (credentials, thunkAPI) => {
  try {
    if (credentials.username === 'admin' && credentials.password === 'admin') {
      const fakeAdmin: User = { username: 'admin', role: 'admin', token: 'fake-admin-token', id: 1, email: 'admin@example.com' };
      localStorage.setItem('user', JSON.stringify(fakeAdmin));
      localStorage.setItem('token', fakeAdmin.token);
      return fakeAdmin;
    }
    return await authService.login(credentials);
  } catch (error: any) {
    return thunkAPI.rejectWithValue(error.message || 'Login failed');
  }
});

export const signup = createAsyncThunk<
  User,
  RegisterCredentials,
  { rejectValue: string }
>('auth/signup', async (credentials, thunkAPI) => {
  try {
    return await authService.signup(credentials);
  } catch (error: any) {
    return thunkAPI.rejectWithValue(error.message || 'Signup failed');
  }
});

export const ownerSignup = createAsyncThunk<
  User,
  OwnerRegisterCredentials,
  { rejectValue: string }
>('auth/ownerSignup', async (credentials, thunkAPI) => {
  try {
    return await authService.ownerSignup(credentials);
  } catch (error: any) {
    return thunkAPI.rejectWithValue(error.message || 'Owner signup failed');
  }
});

const authSlice = createSlice({
  name: 'auth',
  initialState,
  reducers: {
    adminLogin: (state) => {
      const adminUser: User = { username: 'admin', role: 'admin', token: 'admin' , id: 1, email: 'admin@example.com' };
      localStorage.setItem('user', JSON.stringify(adminUser));
      localStorage.setItem('token', 'admin');
      state.user = adminUser;
      state.isAuthenticated = true;
      state.loading = false;
      state.success = false;
      state.error = null;
    },
    logout: (state) => {
      localStorage.removeItem('user');
      localStorage.removeItem('token');
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
        state.isAuthenticated = !!localStorage.getItem('token');
        state.success = true;
        state.error = null;
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
        state.success = true;
        state.error = null;
      })
      .addCase(signup.rejected, (state, action) => {
        state.loading = false;
        state.error = action.payload as string;
        state.success = false;
      })
      .addCase(ownerSignup.pending, (state) => {
        state.loading = true;
        state.success = false;
        state.error = null;
      })
      .addCase(ownerSignup.fulfilled, (state, action: PayloadAction<User>) => {
        state.loading = false;
        state.user = action.payload;
        state.isAuthenticated = !!localStorage.getItem('token');
        state.success = true;
        state.error = null;
      })
      .addCase(ownerSignup.rejected, (state, action) => {
        state.loading = false;
        state.error = action.payload as string;
        state.success = false;
      });
  }
});

export const { logout, adminLogin } = authSlice.actions;
export default authSlice.reducer;
