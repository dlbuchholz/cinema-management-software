import React from 'react';
import { useLocation, useNavigate, useParams } from 'react-router-dom';
import { Button, Card, Typography, message } from 'antd';
import { useSelector } from 'react-redux';
import { RootState } from '../store/store';
import cinemaService from '../services/cinemaService';

const { Title, Text } = Typography;

const Booking: React.FC = () => {
    const { ticketId } = useParams<{ ticketId?: string }>();
    const location = useLocation();
    const navigate = useNavigate();
    const user = useSelector((state: RootState) => state.auth.user);
    const selectedSeats = location.state?.selectedSeats || [];
    const screeningId = ticketId ? undefined : location.pathname.split('/').pop();

    const totalPrice = selectedSeats.length * 12;

    const handleConfirmBooking = async () => {
        try {
            if (!user) {
                message.error('You must be logged in to book tickets.');
                return;
            }

            if (ticketId) {
                // Booking a single reserved ticket
                await cinemaService.bookTicket(Number(ticketId));
            } else if (screeningId) {
                // Booking multiple tickets (creating tickets for each seat)
                for (const seatId of selectedSeats) {
                    await cinemaService.createBookedTicket({
                        customerId: user.id,
                        screeningId: Number(screeningId),
                        seatId,
                        price: 12,
                    });
                }
            }

            message.success('Tickets booked successfully');
            navigate('/confirmation');
        } catch (error) {
            message.error('Error booking tickets');
        }
    };

    return (
        <div style={{ padding: '20px' }}>
            <Card>
                <Title level={3}>Booking Confirmation</Title>
                <Text>Name: {user?.username}</Text><br />
                <Text>Email: {user?.email}</Text><br />
                <Text>Number of Seats: {selectedSeats.length || 1}</Text><br />
                <Text>Total Price: {totalPrice}€</Text>
                <div style={{ marginTop: '20px' }}>
                    <Button type="primary" onClick={handleConfirmBooking}>Confirm Booking</Button>
                </div>
            </Card>
        </div>
    );
};

export default Booking;
