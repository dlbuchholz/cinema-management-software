import React from 'react';
import { Layout as AntLayout, Menu, Breadcrumb, LayoutProps } from 'antd';
import { Link, Outlet, useLocation } from 'react-router-dom';
import {
    HomeOutlined,
    DashboardOutlined,
    UserOutlined
} from '@ant-design/icons';
import styles from '../../assets/styles/Layout.module.css';

const { Header, Content, Footer, Sider } = AntLayout;

const Layout: React.FC<LayoutProps> = ({ children }) => {
    const location = useLocation();

    return (
        <AntLayout style={{ minHeight: '100vh' }}>
            <Sider
                breakpoint="lg"
                collapsedWidth="0"
                onBreakpoint={(broken) => {
                    console.log(broken);
                }}
                onCollapse={(collapsed, type) => {
                    console.log(collapsed, type);
                }}
            >
                <div className={styles.logo}>Cinema Management</div>
                <Menu
                    theme="dark"
                    mode="inline"
                    defaultSelectedKeys={[location.pathname]}
                >
                    <Menu.Item key="/" icon={<HomeOutlined />}>
                        <Link to="/">Dashboard</Link>
                    </Menu.Item>
                    <Menu.Item key="/admin" icon={<UserOutlined />}>
                        <Link to="/admin">Admin Panel</Link>
                    </Menu.Item>
                </Menu>
            </Sider>
            <AntLayout>
                <Header className={styles.header}>
                    <Menu mode="horizontal" defaultSelectedKeys={['home']}>
                        <Menu.Item key="home" icon={<DashboardOutlined />}>
                            <Link to="/">Dashboard</Link>
                        </Menu.Item>
                        <Menu.Item key="admin" icon={<UserOutlined />}>
                            <Link to="/admin">Admin Panel</Link>
                        </Menu.Item>
                    </Menu>
                </Header>
                <Content style={{ width: '100%', margin: '24px 16px 0' }}>
                    <Breadcrumb style={{ margin: '16px 0' }}>
                        <Breadcrumb.Item>Home</Breadcrumb.Item>
                        <Breadcrumb.Item>
                            {location.pathname === '/admin' ? 'Admin Panel' : 'Dashboard'}
                        </Breadcrumb.Item>
                    </Breadcrumb>
                    <div className={styles.content}>
                        <Outlet />
                    </div>
                    {children}
                </Content>
                <Footer style={{ textAlign: 'center' }}>
                    Cinema Management Software ©2025
                </Footer>
            </AntLayout>
        </AntLayout>
    );
};

export default Layout;
