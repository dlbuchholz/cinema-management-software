import React from 'react';
import { useSelector } from 'react-redux';
import { RootState } from '../store/store';

import Layout from '../components/Layout/Layout';
import FilmList from '../components/Cinema/FilmList';

const Dashboard: React.FC = () => {
    const { user } = useSelector((state: RootState) => state.auth);

    return (
        <Layout>
            {user?.role === 'admin' && (
                <p>You are an admin. You can access the <a href="/admin">Admin Panel</a>.</p>
            )}
            <FilmList />
        </Layout>
    );
};

export default Dashboard;
