package com.cinemamanagementsoftware.statisticsservice;

import org.neo4j.driver.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@SuppressWarnings("deprecation")
public class CinemaStatisticsService {

    private final Driver neo4jDriver;

    public CinemaStatisticsService(Driver neo4jDriver) {
        this.neo4jDriver = neo4jDriver;
    }
    
    /** Add a new Cinema Hall to the graph */
    public void addCinemaHallToGraph(Long hallId, String name) {
        try (Session session = neo4jDriver.session()) {
            session.writeTransaction(tx -> tx.run(
                "CREATE (:CinemaHall {id: $hallId, name: $name})",
                Values.parameters("hallId", hallId, "name", name)
            ));
        }
    }

    /** Remove a Cinema Hall from the graph */
    public void removeCinemaHallFromGraph(Long hallId) {
        try (Session session = neo4jDriver.session()) {
            session.writeTransaction(tx -> tx.run(
                "MATCH (h:CinemaHall {id: $hallId}) DETACH DELETE h",
                Values.parameters("hallId", hallId)
            ));
        }
    }

    /** Add a Seating Row to the Graph */
    public void addSeatingRowToGraph(Long rowId, Long hallId, String category, int rowNumber) {
        try (Session session = neo4jDriver.session()) {
            session.writeTransaction(tx -> tx.run(
                "MATCH (h:CinemaHall {id: $hallId}) " +
                "CREATE (r:SeatingRow {id: $rowId, category: $category, rowNumber: $rowNumber})-[:IN_HALL]->(h)",
                Values.parameters("rowId", rowId, "hallId", hallId, "category", category, "rowNumber", rowNumber)
            ));
        }
    }

    /** Remove a Seating Row from the Graph */
    public void removeSeatingRowFromGraph(Long rowId) {
        try (Session session = neo4jDriver.session()) {
            session.writeTransaction(tx -> tx.run(
                "MATCH (r:SeatingRow {id: $rowId}) DETACH DELETE r",
                Values.parameters("rowId", rowId)
            ));
        }
    }

    /** Add a Seat to the Graph */
    public void addSeatToGraph(Long seatId, Long rowId, int seatNumber) {
        try (Session session = neo4jDriver.session()) {
            session.writeTransaction(tx -> tx.run(
                "MATCH (r:SeatingRow {id: $rowId}) " +
                "CREATE (s:Seat {id: $seatId, seatNumber: $seatNumber})-[:IN_ROW]->(r)",
                Values.parameters("seatId", seatId, "rowId", rowId, "seatNumber", seatNumber)
            ));
        }
    }

    /** Remove a Seat from the Graph */
    public void removeSeatFromGraph(Long seatId) {
        try (Session session = neo4jDriver.session()) {
            session.writeTransaction(tx -> tx.run(
                "MATCH (s:Seat {id: $seatId}) DETACH DELETE s",
                Values.parameters("seatId", seatId)
            ));
        }
    }

    /** Add a booking to the graph */
	public void addBookingToGraph(Long bookingId, Long screeningId, Long customerId, Double totalPrice) {
        try (Session session = neo4jDriver.session()) {
            session.writeTransaction(tx -> tx.run(
                "MATCH (s:Screening {id: $screeningId}), (c:Customer {id: $customerId}) " +
                "CREATE (b:Booking {id: $bookingId, totalPrice: $totalPrice})-[:FOR_SCREENING]->(s), " +
                "(c)-[:MADE_BOOKING]->(b)",
                Values.parameters("bookingId", bookingId, "screeningId", screeningId, "customerId", customerId, "totalPrice", totalPrice)
            ));
        }
    }

    /** Remove a booking */
    public void removeBookingFromGraph(Long bookingId) {
        try (Session session = neo4jDriver.session()) {
            session.writeTransaction(tx -> tx.run("MATCH (b:Booking {id: $bookingId}) DETACH DELETE b", 
                Values.parameters("bookingId", bookingId)
            ));
        }
    }
    
    /** Add a new movie to the graph database */
    public void addMovieToGraph(Long movieId, String title, String genre, String description, Double length) {
        try (Session session = neo4jDriver.session()) {
            session.writeTransaction(tx -> tx.run(
                "CREATE (:Movie {id: $movieId, title: $title, genre: $genre, description: $description, length: $length})",
                Values.parameters("movieId", movieId, "title", title, "genre", genre, "description", description, "length", length)
            ));
        }
    }

    /** Add a screening */
    public void addScreeningToGraph(Long screeningId, Long movieId, Long hallId, String date, Double startTime, Double endTime) {
        try (Session session = neo4jDriver.session()) {
            session.writeTransaction(tx -> tx.run(
                "MATCH (m:Movie {id: $movieId}), (h:CinemaHall {id: $hallId}) " +
                "CREATE (s:Screening {id: $screeningId, date: date($date), startTime: $startTime, endTime: $endTime}) " +
                "-[:FOR_MOVIE]->(m), (s)-[:IN_HALL]->(h)",
                Values.parameters("screeningId", screeningId, "movieId", movieId, "hallId", hallId, "date", date, "startTime", startTime, "endTime", endTime)
            ));
        }
    }
    
    /** Update screening details */
    public void updateScreeningInGraph(Long screeningId, String date, Double startTime, Double endTime) {
        try (Session session = neo4jDriver.session()) {
            session.writeTransaction(tx -> tx.run(
                "MATCH (s:Screening {id: $screeningId}) " +
                "SET s.date = date($date), s.startTime = $startTime, s.endTime = $endTime",
                Values.parameters("screeningId", screeningId, "date", date, "startTime", startTime, "endTime", endTime)
            ));
        }
    }

    /** Remove a screening */
    public void removeScreeningFromGraph(Long screeningId) {
        try (Session session = neo4jDriver.session()) {
            session.writeTransaction(tx -> tx.run("MATCH (s:Screening {id: $screeningId}) DETACH DELETE s",
                Values.parameters("screeningId", screeningId)
            ));
        }
    }

    /** Add a customer */
    public void addCustomerToGraph(Long customerId, String name, String email, String telephone) {
        try (Session session = neo4jDriver.session()) {
            session.writeTransaction(tx -> tx.run(
                "CREATE (:Customer {id: $customerId, name: $name, email: $email, telephone: $telephone})",
                Values.parameters("customerId", customerId, "name", name, "email", email, "telephone", telephone)
            ));
        }
    }

    /** Remove a customer */
    public void removeCustomerFromGraph(Long customerId) {
        try (Session session = neo4jDriver.session()) {
            session.writeTransaction(tx -> tx.run("MATCH (c:Customer {id: $customerId}) DETACH DELETE c",
                Values.parameters("customerId", customerId)
            ));
        }
    }

    /** Get revenue by screening */
    public Double getRevenueByScreening(Long screeningId) {
        try (Session session = neo4jDriver.session()) {
            return session.readTransaction(tx -> {
                Result result = tx.run(
                    "MATCH (b:Booking)-[:FOR_SCREENING]->(s:Screening {id: $screeningId}) " +
                    "RETURN SUM(b.totalPrice) AS revenue",
                    Values.parameters("screeningId", screeningId)
                );
                return result.hasNext() ? result.single().get("revenue").asDouble(0.0) : 0.0;
            });
        }
    }

    /** Get revenue by movie */
    public Double getRevenueByMovie(Long movieId) {
        try (Session session = neo4jDriver.session()) {
            return session.readTransaction(tx -> {
                Result result = tx.run(
                    "MATCH (b:Booking)-[:FOR_SCREENING]->(s:Screening)-[:FOR_MOVIE]->(m:Movie {id: $movieId}) " +
                    "RETURN SUM(b.totalPrice) AS revenue",
                    Values.parameters("movieId", movieId)
                );
                return result.hasNext() ? result.single().get("revenue").asDouble(0.0) : 0.0;
            });
        }
    }

    /** Get revenue by cinema hall */
    public Double getRevenueByCinemaHall(Long hallId) {
        try (Session session = neo4jDriver.session()) {
            return session.readTransaction(tx -> {
                Result result = tx.run(
                    "MATCH (b:Booking)-[:FOR_SCREENING]->(s:Screening)-[:IN_HALL]->(h:CinemaHall {id: $hallId}) " +
                    "RETURN SUM(b.totalPrice) AS revenue",
                    Values.parameters("hallId", hallId)
                );
                return result.hasNext() ? result.single().get("revenue").asDouble(0.0) : 0.0;
            });
        }
    }
    
    /** Get revenue by date range */
    public Double getRevenueByDateRange(String from, String to) {
        try (Session session = neo4jDriver.session()) {
            return session.readTransaction(tx -> {
                Result result = tx.run(
                    "MATCH (b:Booking)-[:FOR_SCREENING]->(s:Screening) " +
                    "WHERE s.date >= date($from) AND s.date <= date($to) " +
                    "RETURN SUM(b.totalPrice) AS revenue",
                    Values.parameters("from", from, "to", to)
                );
                return result.hasNext() ? result.single().get("revenue").asDouble(0.0) : 0.0;
            });
        }
    }

    /** Get top movies */
    public List<Map<String, Object>> getTopMovies() {
        try (Session session = neo4jDriver.session()) {
            return session.readTransaction(tx -> {
                Result result = tx.run(
                    "MATCH (m:Movie)<-[:FOR_MOVIE]-(s:Screening)<-[:FOR_SCREENING]-(b:Booking) " +
                    "RETURN m.title AS movie, COUNT(b) AS totalBookings ORDER BY totalBookings DESC LIMIT 5"
                );
                return result.list(record -> Map.of(
                    "movie", record.get("movie").asString(),
                    "totalBookings", record.get("totalBookings").asInt()
                ));
            });
        }
    }

    /** Get occupancy rate for a screening */
    public Double getOccupancyByScreening(Long screeningId) {
        try (Session session = neo4jDriver.session()) {
            return session.readTransaction(tx -> {
                Result result = tx.run(
                    "MATCH (s:Screening {id: $screeningId})<-[:FOR_SCREENING]-(b:Booking) " +
                    "MATCH (s)-[:IN_HALL]->(h:CinemaHall) " +
                    "MATCH (h)-[:HAS_ROW]->(r:SeatingRow)-[:HAS_SEAT]->(seat) " +
                    "WITH COUNT(b) AS bookedSeats, COUNT(seat) AS totalSeats " +
                    "RETURN (toFloat(bookedSeats) / totalSeats) * 100 AS occupancyRate",
                    Values.parameters("screeningId", screeningId)
                );
                return result.hasNext() ? result.single().get("occupancyRate").asDouble(0.0) : 0.0;
            });
        }
    }
    

    /** Get occupancy rate for a cinema hall */
    public Double getOccupancyByHall(Long hallId) {
        try (Session session = neo4jDriver.session()) {
            return session.readTransaction(tx -> {
                Result result = tx.run(
                    "MATCH (h:CinemaHall {id: $hallId}) " +
                    "MATCH (h)-[:HAS_SCREENING]->(s:Screening)<-[:FOR_SCREENING]-(b:Booking) " +
                    "MATCH (h)-[:HAS_ROW]->(r:SeatingRow)-[:HAS_SEAT]->(seat) " +
                    "WITH COUNT(b) AS bookedSeats, COUNT(seat) AS totalSeats " +
                    "RETURN (toFloat(bookedSeats) / totalSeats) * 100 AS occupancyRate",
                    Values.parameters("hallId", hallId)
                );
                return result.hasNext() ? result.single().get("occupancyRate").asDouble(0.0) : 0.0;
            });
        }
    }

    /** Get customer booking trends */
    public List<Map<String, Object>> getCustomerTrends() {
        try (Session session = neo4jDriver.session()) {
            return session.readTransaction(tx -> {
                Result result = tx.run(
                    "MATCH (c:Customer)-[:MADE_BOOKING]->(b:Booking) " +
                    "RETURN c.id AS customerId, COUNT(b) AS totalBookings, " +
                    "AVG(b.totalPrice) AS avgSpent ORDER BY totalBookings DESC LIMIT 10"
                );
                return result.list(record -> Map.of(
                    "customerId", record.get("customerId").asLong(),
                    "totalBookings", record.get("totalBookings").asInt(),
                    "avgSpent", record.get("avgSpent").asDouble(0.0)
                ));
            });
        }
    }

    /** Get top screenings */
    public List<Map<String, Object>> getTopScreenings() {
        try (Session session = neo4jDriver.session()) {
            return session.readTransaction(tx -> {
                Result result = tx.run(
                    "MATCH (s:Screening)<-[:FOR_SCREENING]-(b:Booking) " +
                    "RETURN s.id AS screeningId, COUNT(b) AS totalBookings ORDER BY totalBookings DESC LIMIT 5"
                );
                return result.list(record -> Map.of(
                    "screeningId", record.get("screeningId").asLong(),
                    "totalBookings", record.get("totalBookings").asInt()
                ));
            });
        }
    }
}