// src/pages/AccountView.tsx

import React from 'react';
import { Button, Space, Typography, Card } from 'antd';
import { useNavigate, Outlet } from 'react-router-dom';

const { Title } = Typography;

const AccountView: React.FC = () => {
  const navigate = useNavigate();

  return (
    <div
      style={{
        padding: '40px',
        minHeight: '100vh',
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
      }}
    >
      <Card
        style={{
          width: '100%',
          marginBottom: '40px',
          borderRadius: '14px',
        }}
      >
        <Title level={2} style={{ textAlign: 'center', color: '#ffffff' }}>
          Admin Accountübersicht
        </Title>
        <Space
          size="large"
          style={{
            display: 'flex',
            justifyContent: 'center',
            marginTop: '20px',
          }}
        >
          <Button
            type="primary"
            size="large"
            onClick={() => navigate('/account/film')}
          >
            Film bearbeiten
          </Button>
          <Button
            type="primary"
            size="large"
            onClick={() => navigate('/account/saal')}
          >
            Filmsaal bearbeiten
          </Button>
        </Space>
        <div style={{ marginTop: '30px', textAlign: 'center' }}>
          <Button size="large" onClick={() => navigate('/account/create')}>
            Neu erstellen
          </Button>
        </div>
      </Card>
      <Outlet />
    </div>
  );
};

export default AccountView;
