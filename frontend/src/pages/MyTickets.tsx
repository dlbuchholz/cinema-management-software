import React, { useEffect, useState } from "react";
import { List, Card, Spin, Typography, message, Button } from "antd";
import cinemaService from "../services/cinemaService";
import { Navigate } from "react-router-dom";
import { Ticket } from "../types";
import moment from "moment";
import { filmImages } from "../assets/images";
import { BookOutlined, CloseOutlined } from '@ant-design/icons';

const { Title, Text } = Typography;

const MyTickets: React.FC = () => {
  const [tickets, setTickets] = useState<Ticket[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const user = JSON.parse(localStorage.getItem('user'))

  const fetchTickets = async () => {
    setLoading(true);
    try {
      const customerId = user.id;
      const data = await cinemaService.getTicketsForCustomer(customerId);
      setTickets(data);
    } catch (error) {
      message.error("Error fetching tickets");
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
    return (
      <Spin
        size="large"
        style={{ display: "block", marginTop: 100, textAlign: "center" }}
      />
    );
  }

  return (
    <div style={{ padding: 20 }}>
      <Title level={2}>My Tickets</Title>
      <Button
        type="primary"
        onClick={fetchTickets}
        style={{ marginBottom: 20 }}
      >
        Refresh
      </Button>
      <List
        grid={{ gutter: 16, column: 4 }}
        dataSource={tickets}
        renderItem={(ticket) => (
          <List.Item>
            <Card
              title={`Ticket #${ticket.id}`}
              actions={[
                <CloseOutlined key="watch" onClick={async () => await cinemaService.cancelReservation(ticket.id)} />,
                <BookOutlined key="screenings" onClick={async () => await cinemaService.confirmReservation(ticket.id)} />,
              ]}
              cover={
                <img
                  src={
                    filmImages[ticket.screening.movie.title] ||
                    filmImages["Astor"]
                  }
                  style={{ width: "100%", height: 360, objectFit: "fill" }}
                />
              }
            >
              <Title level={4}>{ticket.screening.movie.title}</Title>
              <Text>
                Cinema: {ticket.screening.cinemaHall.cinema?.name} -{" "}
                {ticket.screening.cinemaHall.name}
              </Text>
              <br />
              <Text>
                Screening:{" "}
                {moment(ticket.screening.date).format("dddd DD.MM.yyyy")}
              </Text>
              <br />
              <Text>Seat Number: {ticket.seat.seatNumber}</Text>
              <br />
              <Text>Price: ${ticket.price}</Text>
              <br />
              {ticket.bookedStatus && (
                <Text>Booking Time: {ticket.bookingTime}</Text>
              )}
            </Card>
          </List.Item>
        )}
      />
    </div>
  );
};

export default MyTickets;
