package com.cinemamanagementsoftware.statisticsservice.consumers;

import com.cinemamanagementsoftware.statisticsservice.CinemaStatisticsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsCommandConsumer {

    private final CinemaStatisticsService statisticsService;

    public StatisticsCommandConsumer(CinemaStatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    /** Fetch revenue for a specific screening */
    @RabbitListener(queues = "statistics.revenue.screening")
    public Double fetchRevenueByScreening(Long screeningId) {
        return statisticsService.getRevenueByScreening(screeningId);
    }

    /** Fetch revenue for a specific movie */
    @RabbitListener(queues = "statistics.revenue.movie")
    public Double fetchRevenueByMovie(Long movieId) {
        return statisticsService.getRevenueByMovie(movieId);
    }

    /** Fetch revenue for a specific cinema hall */
    @RabbitListener(queues = "statistics.revenue.cinema-hall")
    public Double fetchRevenueByCinemaHall(Long hallId) {
        return statisticsService.getRevenueByCinemaHall(hallId);
    }

    /** Fetch revenue within a date range */
    @RabbitListener(queues = "statistics.revenue.date-range")
    public Double fetchRevenueByDateRange(Map<String, String> dateRange) {
        return statisticsService.getRevenueByDateRange(dateRange.get("from"), dateRange.get("to"));
    }

    /** Fetch occupancy rate for a screening */
    @RabbitListener(queues = "statistics.occupancy.screening")
    public Double fetchOccupancyByScreening(Long screeningId) {
        return statisticsService.getOccupancyByScreening(screeningId);
    }

    /** Fetch occupancy rate for a cinema hall */
    @RabbitListener(queues = "statistics.occupancy.hall")
    public Double fetchOccupancyByHall(Long hallId) {
        return statisticsService.getOccupancyByHall(hallId);
    }

    /** Fetch top-performing movies */
    @RabbitListener(queues = "statistics.top-movies")
    public Collection<Map<String, Object>> fetchTopMovies() {
        return statisticsService.getTopMovies();
    }

    /** Fetch top-performing screenings */
    @RabbitListener(queues = "statistics.top-screenings")
    public Collection<Map<String, Object>> fetchTopScreenings() {
        return statisticsService.getTopScreenings();
    }

    /** Fetch customer trends */
    @RabbitListener(queues = "statistics.customer-trends")
    public Collection<Map<String, Object>> fetchCustomerTrends() {
        return statisticsService.getCustomerTrends();
    }
}