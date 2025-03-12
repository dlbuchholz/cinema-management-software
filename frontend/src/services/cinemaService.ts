import axios from 'axios';
import {Movie, ScreeningData, CinemaHall, SeatingRow, Category, Seat, Ticket, SeatForSelection} from '../types';

const MOVIES_URL = 'http://localhost:8080/api/movies';
const SCREENINGS_URL = 'http://localhost:8080/api/screenings';
const HALLS_URL = 'http://localhost:8080/api/halls';
const API_URL = 'http://localhost:8080/api/ticket';

export interface TicketRequest {
  screeningId: number;
  seatId: number;
}

export interface TicketData {
  customerId: number;
  screeningId: number;
  seatId: number;
  price: number;
}


const createTicket = async (ticket: TicketData): Promise<string> => {
  const payload = {
    customerId: ticket.customerId,
    screeningId: ticket.screeningId,
    seatId: ticket.seatId,
    price: ticket.price
  };
  const response = await axios.post<string>(API_URL, payload, {
    headers: { 'Content-Type': 'application/json' }
  });
  return response.data;
};

const createBookedTicket = async (ticket: TicketData): Promise<string> => {
  const payload = {
    customerId: ticket.customerId,
    screeningId: ticket.screeningId,
    seatId: ticket.seatId,
    price: ticket.price
  };
  const response = await axios.post<string>(API_URL+'/createbooked', payload, {
    headers: { 'Content-Type': 'application/json' }
  });
  return response.data;
};

const getCustomerTicketsForScreening = async (customerId: number, screeningId: number): Promise<string> => {
  const response = await axios.get<string>(`${API_URL}/${customerId}/screenings/${screeningId}/tickets`);
  return response.data;
};

const getTicketsForScreening = async (screeningId: number): Promise<string> => {
  const response = await axios.get<string>(`${API_URL}/${screeningId}/tickets`);
  return response.data;
};

const getTicketsForCustomer = async (customerId: number): Promise<string> => {
  const response = await axios.get<string>(`${API_URL}/${customerId}/tickets`);
  return response.data;
};

const deleteTicket = async (ticketId: number): Promise<string> => {
  const response = await axios.delete<string>(`${API_URL}/${ticketId}`);
  return response.data;
};

const bookTicket = async (ticketId: number): Promise<string> => {
  const response = await axios.patch<string>(`${API_URL}/${ticketId}/book`);
  return response.data;
};

const getSeatsForScreening = async (screeningId: number): Promise<SeatForSelection[]> => {
  const response = await axios.get<SeatForSelection[]>(`${API_URL}/screenings/${screeningId}/seats`);
  return response.data;
};

/**
 * Creates a new reservation.
 * Endpoint: POST /api/tickets/reservation
 */
const createReservation = async (data: TicketRequest): Promise<Ticket> => {
  const response = await axios.post<Ticket>(`${API_URL}/reservation`, data);
  return response.data;
};

/**
 * Confirms a reservation, converting it into a booking.
 * Endpoint: PATCH /api/tickets/{id}/confirm
 */
const confirmReservation = async (ticketId: number): Promise<Ticket> => {
  const response = await axios.patch<Ticket>(`${API_URL}/${ticketId}/confirm`);
  return response.data;
};

/**
 * Cancels a reservation.
 * Endpoint: DELETE /api/tickets/{id}/cancel
 */
const cancelReservation = async (ticketId: number): Promise<{ status: string; message?: string }> => {
  const response = await axios.delete<{ status: string; message?: string }>(`${API_URL}/${ticketId}`);
  return response.data;
};

/**
 * Directly creates a booking (non-cancellable).
 * Endpoint: POST /api/tickets
 */
const createBooking = async (data: TicketRequest): Promise<Ticket> => {
  const response = await axios.post<Ticket>(API_URL, data);
  return response.data;
};

/**
 * Retrieves the details of a ticket (booking or reservation).
 * Endpoint: GET /api/tickets/{id}
 */
const getTicketDetails = async (ticketId: number): Promise<Ticket> => {
  const response = await axios.get<Ticket>(`${API_URL}/${ticketId}`);
  return response.data;
};

/**
 * Retrieves all tickets from a customer.
 * Endpoint: GET /api/tickets/{id}
 */
const getAllTicketsForCustomer = async (userId: number): Promise<Ticket[]> => {
  const response = await axios.get<Ticket[]>(`${API_URL}/${userId}/tickets`);
  return response.data;
};

// ----------------------
// Movie Endpoints
// ----------------------

export const getAllMovies = async (): Promise<Movie[]> => {
  const response = await axios.get<Movie[]>(MOVIES_URL);
  return response.data;
};

export const getMovieById = async (id: string): Promise<Movie> => {
  const response = await axios.get<Movie>(`${MOVIES_URL}/${id}`);
  return response.data;
};

export const createMovie = async (movieData: Movie): Promise<Movie> => {
  const response = await axios.post<Movie>(MOVIES_URL, movieData);
  return response.data;
};

export const updateMovie = async (id: string, movieData: Movie): Promise<Movie> => {
  const response = await axios.patch<Movie>(`${MOVIES_URL}/${id}`, movieData);
  return response.data;
};

export const deleteMovie = async (id: string): Promise<Movie> => {
  const response = await axios.delete<Movie>(`${MOVIES_URL}/${id}`);
  return response.data;
};

export const searchMovies = async (query: string): Promise<Movie[]> => {
  const response = await axios.get<Movie[]>(`${MOVIES_URL}/search`, { params: { query } });
  return response.data;
};

// ----------------------
// Screening Endpoints
// ----------------------

// src/mock/generateSeatingRows.ts

/**
 * Generate seating rows (with seats) for a given CinemaHall.
 *
 * @param rowCount     - How many rows in the hall
 * @param seatsPerRow  - How many seats per row
 * @param hall         - The CinemaHall reference that these rows belong to
 * @returns An array of SeatingRow objects, each containing Seat objects
 */
export function generateSeatingRows(
  rowCount: number,
  seatsPerRow: number,
  hall: CinemaHall
): SeatingRow[] {
  const rows: SeatingRow[] = [];
  let seatIdCounter = 1;

  for (let r = 0; r < rowCount; r++) {
    let cat: Category;
    switch (r % 3) {
      case 0:
        cat = Category.PARQUET;
        break;
      case 1:
        cat = Category.LOGE;
        break;
      default:
        cat = Category.LOGE_SERVICE;
        break;
    }

    const row: SeatingRow = {
      id: r + 1,
      rowNr: r + 1,
      category: cat,
      seats: [],
      cinemaHall: hall,
    };

    const seatArr: Seat[] = [];
    for (let s = 0; s < seatsPerRow; s++) {
      const seat: Seat = {
        id: seatIdCounter,
        seatNumber: s + 1,
        row: row, // link each seat to this row
      };
      seatIdCounter++;
      seatArr.push(seat);
    }

    row.seats = seatArr;
    rows.push(row);
  }

  return rows;
}


export const getScreeningsByMovieId = async (movieId: string): Promise<ScreeningData[]> => {
  const response = await axios.get<ScreeningData[]>(`${SCREENINGS_URL}/movie/${movieId}`);

  return response.data.map(d => ({
    ...d,
    cinemaHall: {
      ...d.cinemaHall,
      seatingRows: generateSeatingRows(5, 5, d.cinemaHall)
    }
  }));
};

export const createScreening = async (movieId: string, screeningData: ScreeningData): Promise<ScreeningData> => {
  // Construct the payload by merging the movieId with screening data.
  const payload = { movieId, ...screeningData };
  const response = await axios.post<ScreeningData>(SCREENINGS_URL, payload);
  return response.data;
};

export const deleteScreening = async (screeningId: string): Promise<ScreeningData> => {
  const response = await axios.delete<ScreeningData>(`${SCREENINGS_URL}/${screeningId}`);
  return response.data;
};

// ----------------------
// Cinema Hall Endpoints
// ----------------------

export const getHalls = async (): Promise<CinemaHall[]> => {
  const response = await axios.get<CinemaHall[]>(HALLS_URL);
  return response.data;
};

export const getHallById = async (id: string): Promise<CinemaHall> => {
  const response = await axios.get<CinemaHall>(`${HALLS_URL}/${id}`);
  return response.data;
};

export const createHall = async (hallData: CinemaHall): Promise<CinemaHall> => {
  const response = await axios.post<CinemaHall>(HALLS_URL, hallData);
  return response.data;
};

export const updateHall = async (id: string, hallData: CinemaHall): Promise<CinemaHall> => {
  const response = await axios.patch<CinemaHall>(`${HALLS_URL}/${id}`, hallData);
  return response.data;
};

export const deleteHall = async (id: string): Promise<CinemaHall> => {
  const response = await axios.delete<CinemaHall>(`${HALLS_URL}/${id}`);
  return response.data;
};

export default {
  getAllMovies,
  getMovieById,
  createMovie,
  updateMovie,
  deleteMovie,
  searchMovies,
  getScreeningsByMovieId,
  createScreening,
  deleteScreening,
  getHalls,
  getHallById,
  createHall,
  createReservation,
  confirmReservation,
  cancelReservation,
  createBooking,
  getTicketDetails,
  updateHall,
  deleteHall,
  createTicket,
  createBookedTicket,
  getCustomerTicketsForScreening,
  getTicketsForScreening,
  getTicketsForCustomer,
  deleteTicket,
  bookTicket,
  getSeatsForScreening,
  getAllTicketsForCustomer
};
