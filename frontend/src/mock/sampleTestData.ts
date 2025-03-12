// src/mock/sampleTestData.ts

import { Category, Movie, ScreeningData, CinemaHall, SeatingRow, Seat } from '../types';

// A sample movie for testing
export const sampleMovie: Movie = {
  id: 1,
  title: "The Test Movie",
  description: "A film used for testing the dashboard functionalities.",
  length: 120,
  genre: "Action",
  posterUrl: "https://via.placeholder.com/300x400?text=Test+Movie",
};

// Create sample seats for the first seating row
const sampleSeatsRow1: Seat[] = [
  { id: 101, seatNumber: 1, row: {} as SeatingRow },
  { id: 102, seatNumber: 2, row: {} as SeatingRow },
  { id: 103, seatNumber: 3, row: {} as SeatingRow },
];

// Create sample seats for the second seating row
const sampleSeatsRow2: Seat[] = [
  { id: 104, seatNumber: 1, row: {} as SeatingRow },
  { id: 105, seatNumber: 2, row: {} as SeatingRow },
  { id: 106, seatNumber: 3, row: {} as SeatingRow },
];

// Create first seating row (e.g., PARQUET category)
const sampleRow1: SeatingRow = {
  id: 1,
  rowNr: 1,
  category: Category.PARQUET,
  seats: sampleSeatsRow1,
  cinemaHall: {} as CinemaHall, // will be assigned below
};

// Create second seating row (e.g., LOGE category)
const sampleRow2: SeatingRow = {
  id: 2,
  rowNr: 2,
  category: Category.LOGE,
  seats: sampleSeatsRow2,
  cinemaHall: {} as CinemaHall, // will be assigned below
};

// Create a sample cinema hall that contains both seating rows
export const sampleCinemaHall: CinemaHall = {
  id: 1,
  name: "Main Hall",
  seatingRows: [sampleRow1, sampleRow2],
};

// Link each seating row back to the cinema hall
sampleRow1.cinemaHall = sampleCinemaHall;
sampleRow2.cinemaHall = sampleCinemaHall;

// Create a sample screening for the sample movie in the sample cinema hall
export const sampleScreening: ScreeningData = {
  id: 1,
  movie: sampleMovie,
  cinemaHall: sampleCinemaHall,
  date: new Date().toISOString(),
  startTime: 18.00,
  endTime: 20.00,
};

// Bundle all sample data into one export object
export const sampleTestData = {
  films: [sampleMovie],
  screenings: [sampleScreening],
};
