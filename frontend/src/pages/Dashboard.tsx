import React from 'react';
import { useSelector } from 'react-redux';
import { RootState } from '../store/store';
import Layout from '../components/Layout/Layout';

const Dashboard: React.FC = () => {
    const { user } = useSelector((state: RootState) => state.auth);

    return (
        <Layout>
            <p>This is your dashboard.</p>
            {user?.role === 'admin' && (
                <p>You are an admin. You can access the <a href="/admin">Admin Panel</a>.</p>
            )}
        </Layout>
    );
};

export default Dashboard;
