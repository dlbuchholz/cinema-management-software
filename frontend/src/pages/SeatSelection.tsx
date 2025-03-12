import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { Button, Card, Typography, message } from 'antd';
import cinemaService from '../services/cinemaService';
import filmService from '../services/filmService';
import { ScreeningData, SeatForSelection } from '../types';
import { useSelector } from 'react-redux';
import { RootState } from '../store/store';

const { Title, Text } = Typography;

const SeatSelection: React.FC = () => {
    const { screeningId } = useParams<{ screeningId: string }>();
    const navigate = useNavigate();
    const [screening, setScreening] = useState<ScreeningData | null>(null);
    const [seats, setSeats] = useState<SeatForSelection[]>([]);
    const [selectedSeats, setSelectedSeats] = useState<number[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
    const user = useSelector((state: RootState) => state.auth.user);

    useEffect(() => {
        if (!user) {
            navigate('/login');
        }
    }, [navigate, user]);

    useEffect(() => {
        const fetchScreeningAndSeats = async () => {
            try {
                const screeningData = await filmService.getScreening(String(screeningId));
                const seatData = await cinemaService.getSeatsForScreening(Number(screeningId));

                setScreening(screeningData);
                setSeats(seatData.sort((a, b) => a.rowNumber - b.rowNumber || a.seatNumber - b.seatNumber));
            } catch (error) {
                message.error('Error loading screening details');
            } finally {
                setLoading(false);
            }
        };

        fetchScreeningAndSeats();
    }, [screeningId]);

    const toggleSeatSelection = (seatId: number) => {
        setSelectedSeats((prev) =>
            prev.includes(seatId) ? prev.filter((id) => id !== seatId) : [...prev, seatId]
        );
    };

    const handleReserve = async () => {
        try {
            if (!user) {
                message.error('You must be logged in to reserve seats.');
                return;
            }

            const updatedSeats = await cinemaService.getSeatsForScreening(Number(screeningId));
            const takenSeats = selectedSeats.filter((id) => updatedSeats.find((s) => s.id === id && s.isTaken));

            if (takenSeats.length) {
                message.error(`Seats ${takenSeats.join(', ')} are already taken!`);
                return;
            }

            for (const seatId of selectedSeats) {
                await cinemaService.createTicket({
                    customerId: user.id,
                    screeningId: Number(screeningId),
                    seatId,
                    price: 12,
                });
            }
            message.success('Seats reserved successfully');
            navigate('/');
        } catch (error) {
            message.error('Error reserving seats');
        }
    };

    const handleBook = async () => {
        navigate(`/booking/${screeningId}`, { state: { selectedSeats } });
    };

    return (
        <div style={{ padding: '20px' }}>
            {loading ? (
                <Text>Loading...</Text>
            ) : (
                <Card>
                    <Title level={3}>{screening?.movie.title} - Seat Selection</Title>
                    <Text>
                        Date: {screening?.date ? new Date(screening.date).toLocaleDateString() : 'Unknown'} |
                        Duration: {screening?.startTime}-{screening?.endTime}
                    </Text>
                    <Text style={{ display: 'block', marginBottom: '10px', color: 'gray' }}>
                        * All tickets cost 12€
                    </Text>
                    <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(50px, 1fr))', gap: '10px', margin: '20px 0' }}>
                        {seats.map((seat) => (
                            <Button
                                key={seat.id}
                                type={selectedSeats.includes(seat.id) ? 'primary' : seat.isTaken ? 'dashed' : 'default'}
                                disabled={seat.isTaken}
                                onClick={() => !seat.isTaken && toggleSeatSelection(seat.id)}
                            >
                                {seat.rowNumber}-{seat.seatNumber}
                            </Button>
                        ))}
                    </div>
                    <div style={{ marginTop: '20px' }}>
                        <Button type="default" onClick={handleReserve} disabled={!selectedSeats.length}>Reserve Now</Button>
                        <Button type="primary" onClick={handleBook} disabled={!selectedSeats.length}>Book Now</Button>
                    </div>
                </Card>
            )}
        </div>
    );
};

export default SeatSelection;
