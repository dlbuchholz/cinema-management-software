package com.cinemamanagementsoftware.statisticsservice.consumers;

import com.cinemamanagementsoftware.statisticsservice.CinemaStatisticsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StatisticsEventConsumer {

        private final CinemaStatisticsService statisticsService;

    public StatisticsEventConsumer(CinemaStatisticsService statisticsService) {
        this.statisticsService = statisticsService;
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

    /** Handle new screening creation */
    @RabbitListener(queues = "event.screening.created")
    public void handleNewScreening(Map<String, Object> screeningData) {
        Long screeningId = Long.parseLong(screeningData.get("id").toString());
        Long movieId = Long.parseLong(screeningData.get("movieId").toString());
        Long hallId = Long.parseLong(screeningData.get("cinemaHallId").toString());
        String date = screeningData.get("date").toString();
        Double startTime = Double.parseDouble(screeningData.get("startTime").toString());
        Double endTime = Double.parseDouble(screeningData.get("endTime").toString());

        statisticsService.addScreeningToGraph(screeningId, movieId, hallId, date, startTime, endTime);
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
        Long customerId = Long.parseLong(customerData.get("id").toString());
        String name = customerData.get("name").toString();
        String email = customerData.get("email").toString();

        statisticsService.addCustomerToGraph(customerId, name, email);
    }

    /** Handle customer account deletions */
    @RabbitListener(queues = "event.customer.deleted")
    public void handleCustomerDeletion(Long customerId) {
        statisticsService.removeCustomerFromGraph(customerId);
    }
}