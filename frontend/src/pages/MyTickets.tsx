import React, { useEffect, useState } from 'react';
import { List, Card, Spin, Typography, message, Button } from 'antd';
import { useSelector } from 'react-redux';
import { RootState } from '../store/store';
import cinemaService from '../services/cinemaService';
import { Navigate } from 'react-router-dom';

const { Title, Text } = Typography;

interface Ticket {
  id: number;
  screeningId: number;
  seatId: number;
  price: number;
  bookingTime?: string;
}

const MyTickets: React.FC = () => {
  const { user } = useSelector((state: RootState) => state.auth);
  const [tickets, setTickets] = useState<Ticket[]>([]);
  const [loading, setLoading] = useState<boolean>(true);

  const fetchTickets = async () => {
    setLoading(true);
    try {
      const customerId = 1;
      const data = await cinemaService.getTicketsForCustomer(customerId);
      const parsed = JSON.parse(data) as Ticket[];
      setTickets(parsed);
    } catch (error) {
      message.error('Error fetching tickets');
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchTickets();
  }, []);

  if (!user) {
    return <Navigate to="/login" />;
  }

  if (loading) {
    return <Spin size="large" style={{ display: 'block', marginTop: 100, textAlign: 'center' }} />;
  }

  return (
    <div style={{ padding: 20 }}>
      <Title level={2}>My Tickets</Title>
      <Button type="primary" onClick={fetchTickets} style={{ marginBottom: 20 }}>
        Refresh
      </Button>
      <List
        grid={{ gutter: 16, column: 1 }}
        dataSource={tickets}
        renderItem={(ticket) => (
          <List.Item>
            <Card title={`Ticket #${ticket.id}`}>
              <Text>Screening ID: {ticket.screeningId}</Text><br />
              <Text>Seat ID: {ticket.seatId}</Text><br />
              <Text>Price: ${ticket.price}</Text><br />
              {ticket.bookingTime && <Text>Booking Time: {ticket.bookingTime}</Text>}
            </Card>
          </List.Item>
        )}
      />
    </div>
  );
};

export default MyTickets;
