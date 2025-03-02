import React, { useEffect, useState } from 'react';
import { Film, Screening } from '../../services/filmService';
import styles from '../../assets/styles/FilmList.module.css';

import { PlayCircleOutlined, CalendarOutlined } from '@ant-design/icons';
import { Row, Col, Card, Typography, Spin, Modal, List } from 'antd';
import { mockData } from '../../mock/mockData';

const { Title, Text } = Typography;

const FilmList: React.FC = () => {
    const [films, setFilms] = useState<Film[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
    const [selectedFilm, setSelectedFilm] = useState<Film | null>(null);
    const [screenings, setScreenings] = useState<Screening[]>([]);
    const [isModalVisible, setIsModalVisible] = useState<boolean>(false);

    useEffect(() => {
        const fetchFilms = async () => {
            try {
                setFilms(mockData.films);
            } catch (error) {
                console.error('Error fetching films:', error);
            } finally {
                setLoading(false);
            }
        };
        fetchFilms();
    }, []);

    const showModal = (film: Film) => {
        setSelectedFilm(film);
        setScreenings(mockData.screenings.filter(screening => screening.filmId === film.id));
        setIsModalVisible(true);
    };

    const handleCancel = () => {
        setIsModalVisible(false);
        setSelectedFilm(null);
        setScreenings([]);
    };

    if (loading) {
        return <Spin className={styles.loader} size="large" />;
    }

    return (
        <div className={styles.container}>
            <Title level={2} className={styles.title}>🎬 Available Films</Title>
            <Row gutter={[24, 24]} justify="center">
                {films.map((film) => (
                    <Col key={film.id} xs={24} sm={12} md={8} lg={6}>
                        <Card
                            hoverable
                            className={styles.filmCard}
                            cover={
                                <img
                                    alt={film.title}
                                    src={film.posterUrl || 'https://via.placeholder.com/300x400'}
                                    className={styles.filmImage}
                                />
                            }
                            actions={[
                                <PlayCircleOutlined key="watch" />,
                                <CalendarOutlined key="screenings" onClick={() => showModal(film)} />
                            ]}
                        >
                            <Title level={4}>{film.title}</Title>
                            <Text type="secondary">{film.genre} | {film.duration} mins</Text>
                            <p>{film.description.slice(0, 60)}...</p>
                        </Card>
                    </Col>
                ))}
            </Row>
            <Modal 
                title={selectedFilm?.title} 
                open={isModalVisible} 
                onCancel={handleCancel} 
                footer={null}
            >
                {selectedFilm && (
                    <div>
                        <img 
                            src={selectedFilm.posterUrl || 'https://via.placeholder.com/300x400'} 
                            alt={selectedFilm.title} 
                            className={styles.modalImage} 
                        />
                        <Title level={4}>{selectedFilm.genre} | {selectedFilm.duration} mins</Title>
                        <Text>{selectedFilm.description}</Text>

                        <Title level={5} className={styles.screeningTitle}>Available Screenings</Title>
                        <List
                            dataSource={screenings}
                            renderItem={(screening) => (
                                <List.Item>
                                    <Text>
                                        🎥 <b>{screening.cinemaHall}</b> | 🕒 {new Date(screening.startTime).toLocaleString()} | 🪑 {screening.availableSeats} seats
                                    </Text>
                                </List.Item>
                            )}
                        />
                    </div>
                )}
            </Modal>
        </div>
    );
};

export default FilmList;
