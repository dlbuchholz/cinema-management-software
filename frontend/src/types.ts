/**
 * Category enumeration for seating categories.
 */
export enum Category {
  PARQUET = "PARQUET",
  LOGE = "LOGE",
  LOGE_SERVICE = "LOGE_SERVICE",
}

/**
 * Base Person interface.
 */
export interface Person {
  id: number;
  password: string;
  email: string;
}

/**
 * CinemaOwner extends Person.
 */
export interface CinemaOwner extends Person {
  ownerType: 'cinemaOwner';
}


/**
 * Customer extends Person with extra details.
 */
export interface Customer extends Person {
  name: string;
  surname: string;
  telephone: string;
  tickets?: Ticket[];
}

/**
 * Cinema model: A cinema has an id, name, location, an owner, and one or more halls.
 */
export interface Cinema {
  id: number;
  name: string;
  location: string;
  owner: CinemaOwner;
  halls: CinemaHall[];
}

/**
 * CinemaHall model: Represents a cinema hall with a list of seating rows.
 */
export interface CinemaHall {
  id: number;
  name: string;
  seatingRows: SeatingRow[];
  cinema?: Cinema;
}

/**
 * Movie model: Represents a film with details.
 */
export interface Movie {
  id: number;
  title: string;
  description: string;
  length: number;
  genre: string;
  posterUrl?: string;
}

/**
 * Screening model: Represents a screening of a movie in a specific hall.
 */
export interface Screening {
  id: number;
  movie: Movie;
  cinemaHall: CinemaHall;
  date: Date | string;
  startTime: number;
  endTime: number;
}

/**
 * Seat model: Represents an individual seat in a seating row.
 */
export interface Seat {
  id: number;
  row: SeatingRow;
  seatNumber: number;
}

/**
 * SeatingRow model: A row in a cinema hall containing seats.
 */
export interface SeatingRow {
  id: number;
  rowNr: number;
  category: Category;
  seats: Seat[];
  cinemaHall: CinemaHall;
}

/**
 * Ticket model: Represents a ticket for a screening.
 */
export interface Ticket {
  id: number;
  screening: Screening;
  seat: Seat;
  price: number;
  isBooked: boolean;
}
