import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import filmService, { Screening } from '../../services/filmService';

const FilmScreenings: React.FC = () => {
    const { filmId } = useParams<{ filmId: string }>();
    const [screenings, setScreenings] = useState<Screening[]>([]);
    const [loading, setLoading] = useState<boolean>(true);

    useEffect(() => {
        const fetchScreenings = async () => {
            try {
                if (filmId) {
                    const data = await filmService.getFilmScreenings(filmId);
                    setScreenings(data);
                }
            } catch (error) {
                console.error('Error fetching screenings:', error);
            } finally {
                setLoading(false);
            }
        };
        fetchScreenings();
    }, [filmId]);

    if (loading) return <p>Loading screenings...</p>;

    return (
        <div>
            <h2>Screenings</h2>
            <ul>
                {screenings.map((screening) => (
                    <li key={screening.id}>
                        <p>Hall: {screening.cinemaHall}</p>
                        <p>Start: {new Date(screening.startTime).toLocaleString()}</p>
                        <p>End: {new Date(screening.endTime).toLocaleString()}</p>
                        <p>Available Seats: {screening.availableSeats}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default FilmScreenings;
