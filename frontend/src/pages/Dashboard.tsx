// src/pages/Dashboard.tsx

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

  // State for screening selection
  const [selectedFilm, setSelectedFilm] = useState<Movie | null>(null);
  const [screenings, setScreenings] = useState<Screening[]>([]);
  const [isScreeningModalVisible, setIsScreeningModalVisible] = useState<boolean>(false);

  // State for seat selection
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

  // When a film is selected, fetch its screenings and open the screening modal
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

  // When a screening is selected, open the seat selection modal
  const onScreeningSelect = (screening: Screening) => {
    setSelectedScreening(screening);
    setSelectedSeatIds([]); // Reset any previous seat selections
    setIsScreeningModalVisible(false);
    setIsSeatModalVisible(true);
  };

  // Toggle seat selection state
  const toggleSeatSelection = (seatId: number) => {
    setSelectedSeatIds(prev => prev.includes(seatId) ? prev.filter(id => id !== seatId) : [...prev, seatId]);
  };

  // Render seating layout from the selected screening's hall data
  const renderSeatingLayout = () => {
    if (!selectedScreening || !selectedScreening.cinemaHall) return null;
    const hall: CinemaHall = selectedScreening.cinemaHall;
    return (
      <div style={{ display: 'flex', flexDirection: 'column', gap: '16px', alignItems: 'center' }}>
        {hall.seatingRows.map((row: SeatingRow) => (
          <div key={row.id} style={{ width: '100%', textAlign: 'center' }}>
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

  // Book the selected seats by calling the booking endpoint for each seat
  const onBookSeats = async () => {
    if (!selectedScreening) return;
    if (selectedSeatIds.length === 0) {
      message.warning('No seats selected');
      return;
    }
    try {
      // You might choose to batch the request; here we book each seat individually.
      for (const seatId of selectedSeatIds) {
        await cinemaService.createBooking({ screeningId: selectedScreening.id, seatId });
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
          <Col key={film.id} xs={24} sm={12} md={8} lg={6}>
            <Card
              hoverable
              title={film.title}
              cover={
                <img
                  alt={film.title}
                  src={filmImages[film.title] || 'https://via.placeholder.com/300x400'}
                  style={{ width: '100%', height: 250, objectFit: 'cover' }}
                />
              }
              actions={[
                <PlayCircleOutlined key="watch" />,
                <CalendarOutlined key="screenings" onClick={() => onFilmSelect(film)} />,
              ]}
            >
              <Text type="secondary">{film.genre} | {film.length} mins</Text>
              <p>{film.description.slice(0, 60)}...</p>
            </Card>
          </Col>
        ))}
      </Row>

      {/* Screening Modal */}
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

      {/* Seat Selection Modal */}
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
