import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Login from './pages/Login';
import Signup from './pages/Signup';
import Dashboard from './pages/Dashboard';
import AdminPanel from './pages/AdminPanel';
import Layout from './components/Layout/Layout';
import ProtectedRoute from './components/Layout/ProtectedRoute';
import AdminRoute from './components/Layout/AdminRoute';
import AccountView from './pages/AccountView';
import FilmEdit from './pages/FilmEdit';
import FilmDetailEdit from './pages/FilmDetailEdit';
import CinemaHallEdit from './pages/CinemaHallEdit';
import CinemaHallDetailEdit from './pages/CinemaHallDetailEdit';
import CreateFilm from './pages/CreateFilm';
import 'antd/dist/reset.css';
import { message } from 'antd';

message.config({
  top: 100,       
  duration: 3,    
});

const App: React.FC = () => {
    return (
        <Router>
            <Routes>
                <Route path="/login" element={<Login />} />
                <Route path="/signup" element={<Signup />} />

                <Route path="/" element={<Layout />}>
                    <Route index element={<ProtectedRoute><Dashboard /></ProtectedRoute>} />
                    <Route path="/account" element={<AdminRoute><AccountView /></AdminRoute>}>
                        <Route path="film" element={<AdminRoute><FilmEdit /></AdminRoute>} />
                        <Route path="film/:id" element={<AdminRoute><FilmDetailEdit /></AdminRoute>} />
                        <Route path="saal" element={<AdminRoute><CinemaHallEdit /></AdminRoute>} />
                        <Route path="saal/:id" element={<AdminRoute><CinemaHallDetailEdit /></AdminRoute>} />
                        <Route path="create" element={<AdminRoute><CreateFilm /></AdminRoute>} />
                        <Route index element={<Navigate to="film" />} />
                    </Route>
                    <Route path="admin" element={<AdminRoute><AdminPanel /></AdminRoute>} />
                </Route>

                <Route path="*" element={<Navigate to="/" replace />} />
            </Routes>
        </Router>
    );
};

export default App;
