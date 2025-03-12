import axios from 'axios';
import {ScreeningData} from "../types.ts";

export interface Film {
    id: string;
    title: string;
    description: string;
    duration: number;
    genre: string;
    releaseDate: string;
    posterUrl?: string;
}

export interface Screening {
    id: string;
    filmId: string;
    startTime: string;
    endTime: string;  
    cinemaHall: string;
    availableSeats: number;
}

const API_URL = 'http://localhost:8080/api/films';

/**
 * Fetch all available films
 * @returns Promise<Film[]> - A list of available films
 */
const getAvailableFilms = async (): Promise<Film[]> => {
    const response = await axios.get(API_URL);
    return response.data;
};

/**
 * Fetch screenings for a specific film
 * @param filmId - The ID of the film
 * @returns Promise<Screening[]> - A list of screenings for the given film
 */
const getFilmScreenings = async (filmId: string): Promise<Screening[]> => {
    const response = await axios.get(`${API_URL}/${filmId}/screenings`);
    return response.data;
};
const getScreening = async (screeningId: string): Promise<ScreeningData> => {
    const response = await axios.get(`${API_URL}/${screeningId}/screenings`);
    return response.data;
};



export default {
    getAvailableFilms,
    getFilmScreenings,
    getScreening
};
