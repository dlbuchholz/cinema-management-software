import React from 'react';
import { Layout as AntLayout, Menu, Button, LayoutProps } from 'antd';
import { Link, Outlet, useLocation, useNavigate } from 'react-router-dom';
import { UserOutlined, YoutubeOutlined } from '@ant-design/icons';
import styles from '../../assets/styles/Layout.module.css';
import authService from '../../services/authService';
import { useSelector } from 'react-redux';
import { RootState } from '../../store/store';

const { Header, Content, Footer } = AntLayout;

const Layout: React.FC<LayoutProps> = ({ children }) => {
    const location = useLocation();
    const navigate = useNavigate();
    const { user } = useSelector((state: RootState) => state.auth);

    const handleLogout = () => {
        authService.logout();
        navigate('/login');
    };

    return (
        <AntLayout className={styles.layoutContainer}>
            <AntLayout>
                <Header
                    className={styles.header}
                    style={{
                        display: 'flex',
                        justifyContent: 'flex-end',
                        alignItems: 'center',
                        paddingRight: 20,
                    }}
                >
                    <Menu
                        theme="dark"
                        mode="inline"
                        style={{ display: 'flex' }}
                        defaultSelectedKeys={[location.pathname]}
                    >
                        <Menu.Item key="/" icon={<YoutubeOutlined />}>
                            <Link to="/">Filme</Link>
                        </Menu.Item>
                        {user?.role === 'admin' && <Menu.Item key="/account" icon={<UserOutlined />}>
                            <Link to="/account">Admin Panel</Link>
                        </Menu.Item>}
                    </Menu>
                    <Button type="default" onClick={handleLogout}>
                        Logout
                    </Button>
                </Header>
                <Content style={{ margin: '24px 16px 0' }}>
                    <div className={styles.content}>
                        <Outlet />
                        {children}
                    </div>
                </Content>
                <Footer className={styles.footer}>
                    Cinema Management Software ©2025
                </Footer>
            </AntLayout>
        </AntLayout>
    );
};

export default Layout;
