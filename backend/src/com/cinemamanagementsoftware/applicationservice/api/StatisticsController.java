package com.cinemamanagementsoftware.applicationservice.api;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/*
 * 	GET /api/statistics/revenue/screening/{screeningId}
 *	GET /api/statistics/revenue/movie/{movieId}
 *	GET /api/statistics/revenue/cinema-hall/{hallId}
 *	GET /api/statistics/revenue/date-range?from=YYYY-MM-DD&to=YYYY-MM-DD
 *	GET /api/statistics/occupancy/screening/{screeningId}
 *	GET /api/statistics/occupancy/hall/{hallId}
 *	GET /api/statistics/top-movies
 *	GET /api/statistics/top-screenings
 *	GET /api/statistics/customer-trends
 */

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {
    private final RabbitTemplate rabbitTemplate;

    public StatisticsController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/revenue/screening/{screeningId}")
    public Object getScreeningRevenue(@PathVariable Long screeningId) {
        return rabbitTemplate.convertSendAndReceive("statistics.revenue.screening", screeningId);
    }

    @GetMapping("/revenue/movie/{movieId}")
    public Object getMovieRevenue(@PathVariable Long movieId) {
        return rabbitTemplate.convertSendAndReceive("statistics.revenue.movie", movieId);
    }

    @GetMapping("/revenue/cinema-hall/{hallId}")
    public Object getCinemaHallRevenue(@PathVariable Long hallId) {
        return rabbitTemplate.convertSendAndReceive("statistics.revenue.cinema-hall", hallId);
    }

    @GetMapping("/revenue/date-range")
    public Object getRevenueByDateRange(@RequestParam String from, @RequestParam String to) {
        return rabbitTemplate.convertSendAndReceive("statistics.revenue.date-range", from + "," + to);
    }

    @GetMapping("/occupancy/screening/{screeningId}")
    public Object getScreeningOccupancy(@PathVariable Long screeningId) {
        return rabbitTemplate.convertSendAndReceive("statistics.occupancy.screening", screeningId);
    }

    @GetMapping("/occupancy/hall/{hallId}")
    public Object getHallOccupancy(@PathVariable Long hallId) {
        return rabbitTemplate.convertSendAndReceive("statistics.occupancy.hall", hallId);
    }

    @GetMapping("/top-movies")
    public Object getTopMovies() {
        return rabbitTemplate.convertSendAndReceive("statistics.top-movies", "");
    }

    @GetMapping("/top-screenings")
    public Object getTopScreenings() {
        return rabbitTemplate.convertSendAndReceive("statistics.top-screenings", "");
    }

    @GetMapping("/customer-trends")
    public Object getCustomerTrends() {
        return rabbitTemplate.convertSendAndReceive("statistics.customer-trends", "");
    }
}