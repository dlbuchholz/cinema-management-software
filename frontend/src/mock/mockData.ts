import { faker } from '@faker-js/faker';
import { Film, Screening } from '../services/filmService';

const GENRES = ["Action", "Comedy", "Drama", "Horror", "Sci-Fi", "Thriller", "Romance", "Fantasy"];

const generateFilm = (): Film => {
    const duration = faker.number.int({ min: 90, max: 180 });
    return {
        id: faker.string.uuid(),
        title: faker.lorem.words(3),
        description: faker.lorem.sentences(2),
        duration,
        genre: faker.helpers.arrayElement(GENRES),
        releaseDate: faker.date.past({ years: 5 }).toISOString(),
        posterUrl: "https://cdn.premiumkino.de/movie/8836/cadf38332d5ec5a5b1b47dd2c96ed056_w600.jpg"
    };
};

const generateScreenings = (filmId: string, count: number = 5): Screening[] => {
    return Array.from({ length: count }, () => {
        const startTime = faker.date.soon({ days: 30 }); // Within the next 30 days
        const endTime = new Date(startTime.getTime() + faker.number.int({ min: 5400000, max: 10800000 })); // 90-180 min later

        return {
            id: faker.string.uuid(),
            filmId,
            startTime: startTime.toISOString(),
            endTime: endTime.toISOString(),
            cinemaHall: `Hall ${faker.number.int({ min: 1, max: 10 })}`,
            availableSeats: faker.number.int({ min: 10, max: 200 })
        };
    });
};

export const generateFakeData = (filmCount: number = 10) => {
    const films = Array.from({ length: filmCount }, generateFilm);
    const screenings = films.flatMap((film) => generateScreenings(film.id));

    return { films, screenings };
};

export const mockData = generateFakeData(8);
