import React, { useEffect, useState } from 'react';
import { Input, Row, Col, Card, Typography, Spin, Modal, List, Button, message } from 'antd';
import { PlayCircleOutlined, CalendarOutlined } from '@ant-design/icons';
import { useSelector } from 'react-redux';
import { RootState } from '../store/store';
import cinemaService from '../services/cinemaService';
import { Movie, Screening, CinemaHall, SeatingRow, Seat } from '../types';
import { filmImages } from '../assets/images';

const { Text, Title } = Typography;
const { Search } = Input;

const categoryColor: Record<string, string> = {
  PARQUET: '#87CEFA',
  LOGE: '#90EE90',
  LOGE_SERVICE: '#FFA500',
};

const Dashboard: React.FC = () => {
  const { user } = useSelector((state: RootState) => state.auth);
  const [films, setFilms] = useState<Movie[]>([]);
  const [searchTerm, setSearchTerm] = useState<string>('');
  const [loading, setLoading] = useState<boolean>(true);
  const [selectedFilm, setSelectedFilm] = useState<Movie | null>(null);
  const [screenings, setScreenings] = useState<Screening[]>([]);
  const [isScreeningModalVisible, setIsScreeningModalVisible] = useState<boolean>(false);
  const [selectedScreening, setSelectedScreening] = useState<Screening | null>(null);
  const [isSeatModalVisible, setIsSeatModalVisible] = useState<boolean>(false);
  const [selectedSeatIds, setSelectedSeatIds] = useState<number[]>([]);

  useEffect(() => {
    const fetchFilms = async () => {
      setLoading(true);
      try {
        let data: Movie[];
        if (searchTerm.trim()) {
          data = await cinemaService.searchMovies(searchTerm);
        } else {
          data = await cinemaService.getAllMovies();
        }
        setFilms(data);
      } catch (error) {
        console.error('Error fetching films:', error);
        message.error('Error fetching films');
      } finally {
        setLoading(false);
      }
    };
    fetchFilms();
  }, [searchTerm]);

  const onFilmSelect = async (film: Movie) => {
    setSelectedFilm(film);
    try {
      const screeningData = await cinemaService.getScreeningsByMovieId(film.id.toString());
      if (!screeningData || screeningData.length === 0) {
        message.warning('No screenings available for this film.');
        return;
      }
      setScreenings(screeningData);
      setIsScreeningModalVisible(true);
    } catch (error) {
      console.error('Error fetching screenings:', error);
      message.error('Error fetching screenings');
    }
  };

  const onScreeningSelect = (screening: Screening) => {
    setSelectedScreening(screening);
    setSelectedSeatIds([]);
    setIsScreeningModalVisible(false);
    setIsSeatModalVisible(true);
  };

  const toggleSeatSelection = (seatId: number) => {
    setSelectedSeatIds(prev => prev.includes(seatId) ? prev.filter(id => id !== seatId) : [...prev, seatId]);
  };

  const renderSeatingLayout = () => {
    if (!selectedScreening || !selectedScreening.cinemaHall) return null;
    const hall: CinemaHall = selectedScreening.cinemaHall;
    return (
      <div style={{ display: 'flex', flexDirection: 'column', gap: '16px', alignItems: 'center' }}>
        {hall.seatingRows.map((row: SeatingRow) => (
          <div key={row.id} style={{ width: '100%', textAlign: 'center', display: 'flex', alignItems: 'center', gap: 10, justifyContent: 'center' }}>
            <Text strong>Row {row.rowNr}</Text>
            <div style={{ display: 'flex', justifyContent: 'center', gap: 8, marginTop: 4 }}>
              {row.seats.map((seat: Seat) => {
                const isSelected = selectedSeatIds.includes(seat.id);
                const bgColor = categoryColor[row.category] || '#ccc';
                return (
                  <Button
                    key={seat.id}
                    style={{
                      backgroundColor: isSelected ? 'black' : bgColor,
                      color: isSelected ? 'white' : 'black',
                      minWidth: 40,
                      padding: '4px 8px',
                      borderRadius: 8,
                      border: 'none',
                    }}
                    onClick={() => toggleSeatSelection(seat.id)}
                  >
                    {seat.seatNumber}
                  </Button>
                );
              })}
            </div>
          </div>
        ))}
      </div>
    );
  };

  const onBookSeats = async () => {
    if (!selectedScreening) return;
    if (selectedSeatIds.length === 0) {
      message.warning('No seats selected');
      return;
    }
    try {
      const customerId = 1;
      const ticketPrice = selectedScreening.ticketPrice || 10.0;
      for (const seatId of selectedSeatIds) {
        await cinemaService.createTicket({ customerId, screeningId: selectedScreening.id, seatId, price: ticketPrice });
      }
      message.success('Seats booked successfully');
      setIsSeatModalVisible(false);
    } catch (error) {
      console.error('Booking failed:', error);
      message.error('Booking failed');
    }
  };

  if (loading) {
    return <Spin size="large" style={{ display: 'block', margin: 'auto', marginTop: 100 }} />;
  }

  return (
    <div style={{ padding: 20 }}>
      {user?.role === 'admin' && (
        <p>You are an admin. You can access the <a href="/account">Admin Panel</a>.</p>
      )}
      <Search
        placeholder="Search films..."
        allowClear
        onSearch={(value) => setSearchTerm(value)}
        style={{ marginBottom: 20 }}
      />
      <Row gutter={[24, 24]} justify="center">
        {films.map((film) => (
          <Col key={film.id} xs={24} sm={12} md={8} lg={4}>
            <Card
              hoverable
              onClick={() => onFilmSelect(film)}
              cover={
                <img
                  alt={film.title}
                  src={filmImages[film.title] || filmImages['Astor']}
                  style={{ width: '100%', height: 360, objectFit: 'fill' }}
                />
              }
              actions={[
                <PlayCircleOutlined key="watch" />,
                <CalendarOutlined key="screenings" onClick={() => onFilmSelect(film)} />,
              ]}
            >
              <Title level={4}>{film.title}</Title>
              <Text type="secondary">{film.genre} | {film.length} mins</Text>
              <p style={{ color: '#e1e1e1' }}>{film.description.slice(0, 30)}...</p>
            </Card>
          </Col>
        ))}
      </Row>
      <Modal
        title={`${selectedFilm?.title} - Screenings`}
        visible={isScreeningModalVisible}
        onCancel={() => setIsScreeningModalVisible(false)}
        footer={null}
      >
        <List
          dataSource={screenings}
          renderItem={(screening) => (
            <List.Item onClick={() => onScreeningSelect(screening)} style={{ cursor: 'pointer' }}>
              <List.Item.Meta
                title={`Hall: ${screening.cinemaHall?.name}`}
                description={`Starts: ${new Date(screening.startTime).toLocaleString()}`}
              />
            </List.Item>
          )}
        />
      </Modal>
      <Modal
        title="Select Your Seats"
        visible={isSeatModalVisible}
        onCancel={() => setIsSeatModalVisible(false)}
        footer={[
          <Button key="cancel" onClick={() => setIsSeatModalVisible(false)}>
            Cancel
          </Button>,
          <Button key="book" type="primary" onClick={onBookSeats}>
            Book Selected Seats ({selectedSeatIds.length})
          </Button>,
        ]}
      >
        {renderSeatingLayout()}
      </Modal>
    </div>
  );
};

export default Dashboard;
