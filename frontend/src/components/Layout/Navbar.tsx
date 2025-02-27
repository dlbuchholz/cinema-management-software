import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { RootState, AppDispatch } from '../../store/store';
import { logout } from '../../features/auth/authSlice';

const Navbar: React.FC = () => {
    const navigate = useNavigate();
    const dispatch = useDispatch<AppDispatch>();
    const { isAuthenticated, user } = useSelector((state: RootState) => state.auth);

    const handleLogout = () => {
        dispatch(logout());
        navigate('/login');
    };

    return (
        <nav className="navbar">
            <h2>Cinema Management</h2>
            <ul>
                {isAuthenticated ? (
                    <>
                        <li><Link to="/">Dashboard</Link></li>
                        {user?.role === 'admin' && <li><Link to="/admin">Admin Panel</Link></li>}
                        <li><button onClick={handleLogout} className="logout-button">Logout</button></li>
                    </>
                ) : (
                    <>
                        <li><Link to="/login">Login</Link></li>
                        <li><Link to="/signup">Signup</Link></li>
                    </>
                )}
            </ul>
        </nav>
    );
};

export default Navbar;
