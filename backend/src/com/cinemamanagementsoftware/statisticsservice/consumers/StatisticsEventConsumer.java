package com.cinemamanagementsoftware.statisticsservice.consumers;

import com.cinemamanagementsoftware.statisticsservice.CinemaStatisticsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;



@Service
public class StatisticsEventConsumer {

    private final CinemaStatisticsService statisticsService;

    public StatisticsEventConsumer(CinemaStatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }
    
    /** Handle new Cinema Hall creation */
    @RabbitListener(queues = "event.cinema-hall.created")
    public void handleNewCinemaHall(Map<String, Object> hallData) {
        try {
            Long hallId = Long.parseLong(hallData.get("id").toString());
            String name = hallData.get("name").toString();

            statisticsService.addCinemaHallToGraph(hallId, name);
        } catch (Exception e) {
            System.err.println("❌ Error processing Cinema Hall event: " + e.getMessage());
        }
    }

    /** Handle Cinema Hall removal */
    @RabbitListener(queues = "event.cinema-hall.deleted")
    public void handleRemoveCinemaHall(Map<String, Object> hallData) {
        try {
            Long hallId = Long.parseLong(hallData.get("id").toString());

            statisticsService.removeCinemaHallFromGraph(hallId);
        } catch (Exception e) {
            System.err.println("❌ Error processing Cinema Hall removal event: " + e.getMessage());
        }
    }

    /** Handle new Seating Row creation */
    @RabbitListener(queues = "event.seating-row.created")
    public void handleNewSeatingRow(Map<String, Object> rowData) {
        try {
            Long rowId = Long.parseLong(rowData.get("id").toString());
            Long hallId = Long.parseLong(rowData.get("hallId").toString());
            String category = rowData.get("category").toString();
            int rowNumber = Integer.parseInt(rowData.get("rowNumber").toString());

            statisticsService.addSeatingRowToGraph(rowId, hallId, category, rowNumber);
        } catch (Exception e) {
            System.err.println("❌ Error processing Seating Row event: " + e.getMessage());
        }
    }

    /** Handle Seating Row removal */
    @RabbitListener(queues = "event.seating-row.deleted")
    public void handleRemoveSeatingRow(Map<String, Object> rowData) {
        try {
            Long rowId = Long.parseLong(rowData.get("id").toString());

            statisticsService.removeSeatingRowFromGraph(rowId);
        } catch (Exception e) {
            System.err.println("❌ Error processing Seating Row removal event: " + e.getMessage());
        }
    }

    /** Handle new Seat creation */
    @RabbitListener(queues = "event.seat.created")
    public void handleNewSeat(Map<String, Object> seatData) {
        try {
            Long seatId = Long.parseLong(seatData.get("id").toString());
            Long rowId = Long.parseLong(seatData.get("rowId").toString());
            int seatNumber = Integer.parseInt(seatData.get("seatNumber").toString());

            statisticsService.addSeatToGraph(seatId, rowId, seatNumber);
        } catch (Exception e) {
            System.err.println("❌ Error processing Seat event: " + e.getMessage());
        }
    }

    /** Handle Seat removal */
    @RabbitListener(queues = "event.seat.deleted")
    public void handleRemoveSeat(Map<String, Object> seatData) {
        try {
            Long seatId = Long.parseLong(seatData.get("id").toString());

            statisticsService.removeSeatFromGraph(seatId);
        } catch (Exception e) {
            System.err.println("❌ Error processing Seat removal event: " + e.getMessage());
        }
    }

    /** Handle new booking events */
    @RabbitListener(queues = "event.booking.created")
    public void handleNewBooking(Map<String, Object> bookingData) {
        Long bookingId = Long.parseLong(bookingData.get("bookingId").toString());
        Long screeningId = Long.parseLong(bookingData.get("screeningId").toString());
        Long customerId = Long.parseLong(bookingData.get("customerId").toString());
        Double totalPrice = Double.parseDouble(bookingData.get("totalPrice").toString());

        statisticsService.addBookingToGraph(bookingId, screeningId, customerId, totalPrice);
    }

    /** Handle booking cancellations */
    @RabbitListener(queues = "event.booking.canceled")
    public void handleBookingCancellation(Long bookingId) {
        statisticsService.removeBookingFromGraph(bookingId);
    }
    
    @RabbitListener(queues = "event.movie.created")
    public void handleMovieCreated(Map<String, Object> movieData) {
        statisticsService.addMovieToGraph(
            Long.valueOf(movieData.get("movieId").toString()),
            movieData.get("title").toString(),
            movieData.get("genre").toString(),
            movieData.get("description").toString(),
            Double.parseDouble(movieData.get("length").toString())
        );
    }
    
    @RabbitListener(queues = "event.screening.created")
    public void handleNewScreening(Map<String, Object> screeningData) {
        try {
            // Validate required keys exist
            if (!screeningData.containsKey("id") || 
                !screeningData.containsKey("movieId") || 
                !screeningData.containsKey("cinemaHallId") || 
                !screeningData.containsKey("date") || 
                !screeningData.containsKey("startTime") || 
                !screeningData.containsKey("endTime")) {
                System.err.println("❌ Missing required screening data: " + screeningData);
                return;
            }

            Long screeningId = Long.parseLong(screeningData.get("id").toString());
            Long movieId = Long.parseLong(screeningData.get("movieId").toString());
            Long hallId = Long.parseLong(screeningData.get("cinemaHallId").toString());
            Double startTime = Double.parseDouble(screeningData.get("startTime").toString());
            Double endTime = Double.parseDouble(screeningData.get("endTime").toString());

            String date = screeningData.get("date").toString();

            statisticsService.addScreeningToGraph(screeningId, movieId, hallId, date, startTime, endTime);
        } catch (Exception e) {
            System.err.println("❌ Error processing screening event: " + e.getMessage());
        }
    }
    
    /** Handle screening updates */
    @RabbitListener(queues = "event.screening.updated")
    public void handleScreeningUpdate(Map<String, Object> screeningData) {
        Long screeningId = Long.parseLong(screeningData.get("id").toString());
        String date = screeningData.get("date").toString();
        Double startTime = Double.parseDouble(screeningData.get("startTime").toString());
        Double endTime = Double.parseDouble(screeningData.get("endTime").toString());

        statisticsService.updateScreeningInGraph(screeningId, date, startTime, endTime);
    }

    /** Handle screening deletion */
    @RabbitListener(queues = "event.screening.deleted")
    public void handleScreeningDeletion(Long screeningId) {
        statisticsService.removeScreeningFromGraph(screeningId);
    }

    /** Handle new customer registrations */
    @RabbitListener(queues = "event.customer.registered")
    public void handleNewCustomer(Map<String, Object> customerData) {
        try {
            if (customerData == null || !customerData.containsKey("id") || 
                !customerData.containsKey("name") || !customerData.containsKey("email") || 
                !customerData.containsKey("telephone")) {
                System.err.println("❌ Invalid customer data received: " + customerData);
                return;
            }

            Long customerId = Long.parseLong(customerData.get("id").toString());
            String name = customerData.get("name").toString();
            String email = customerData.get("email").toString();
            String telephone = customerData.get("telephone").toString();

            statisticsService.addCustomerToGraph(customerId, name, email, telephone);
        } catch (Exception e) {
            System.err.println("❌ Error processing customer event: " + e.getMessage());
        }
    }

    /** Handle customer account deletions */
    @RabbitListener(queues = "event.customer.deleted")
    public void handleCustomerDeletion(Long customerId) {
        statisticsService.removeCustomerFromGraph(customerId);
    }
}