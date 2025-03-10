// src/pages/CustomerReservations.tsx

import React, { useEffect, useState } from 'react';
import { List, Button, Typography, Spin, message } from 'antd';
import ticketService from '../services/cinemaService';
import { Ticket } from '../types';

const { Title, Text } = Typography;

const CustomerReservations: React.FC = () => {
  const [tickets, setTickets] = useState<Ticket[]>([]);
  const [loading, setLoading] = useState<boolean>(true);

  // Fetch tickets for the currently logged-in customer
  const fetchReservations = async () => {
    setLoading(true);
    try {
      const data = []; // need to see if we have api for it (await ticketService.getMyTickets())
      setTickets(data);
    } catch (error) {
      console.error('Error fetching reservations:', error);
      message.error('Failed to load reservations');
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchReservations();
  }, []);

  // Confirm a reservation (convert it to a confirmed booking)
  const onConfirm = async (ticketId: number) => {
    try {
      await ticketService.confirmReservation(ticketId);
      message.success('Reservation confirmed successfully');
      fetchReservations();
    } catch (error) {
      console.error('Error confirming reservation:', error);
      message.error('Failed to confirm reservation');
    }
  };

  // Cancel a reservation
  const onCancelReservation = async (ticketId: number) => {
    try {
      await ticketService.cancelReservation(ticketId);
      message.success('Reservation canceled successfully');
      fetchReservations();
    } catch (error) {
      console.error('Error canceling reservation:', error);
      message.error('Failed to cancel reservation');
    }
  };

  if (loading) {
    return <Spin size="large" style={{ display: 'block', margin: 'auto', marginTop: 100 }} />;
  }

  return (
    <div style={{ padding: 20 }}>
      <Title level={3}>My Reservations</Title>
      {tickets.length === 0 ? (
        <Text>You currently have no reservations.</Text>
      ) : (
        <List
          itemLayout="horizontal"
          dataSource={tickets}
          renderItem={(ticket) => (
            <List.Item
              actions={[
                !ticket.isBooked && (
                  <Button type="primary" onClick={() => onConfirm(ticket.id)}>
                    Confirm
                  </Button>
                ),
                <Button danger onClick={() => onCancelReservation(ticket.id)}>
                  Cancel
                </Button>,
              ]}
            >
              <List.Item.Meta
                title={`Screening at ${ticket.screening.cinemaHall?.name} on ${new Date(
                  ticket.screening.startTime
                ).toLocaleString()}`}
                description={
                  <>
                    <Text>Seat: {ticket.seat.seatNumber}</Text>
                    <br />
                    <Text>Price: ${ticket.price}</Text>
                    <br />
                    <Text>Booking Status: {ticket.isBooked ? 'Confirmed' : 'Reserved'}</Text>
                  </>
                }
              />
            </List.Item>
          )}
        />
      )}
    </div>
  );
};

export default CustomerReservations;
