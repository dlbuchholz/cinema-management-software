import React from 'react';
import { Navigate } from 'react-router-dom';
import { useSelector } from 'react-redux';
import { RootState } from '../../store/store';

interface Props {
    children: React.ReactNode;
}

const AdminRoute: React.FC<Props> = ({ children }) => {
    const { isAuthenticated, user } = useSelector((state: RootState) => state.auth);

    if (!isAuthenticated || user?.role !== 'admin') {
        return <Navigate to="/" />;
    }

    return <>{children}</>;
};

export default AdminRoute;
