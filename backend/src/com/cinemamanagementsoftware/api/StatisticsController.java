package com.cinemamanagementsoftware.api;

import com.cinemamanagementsoftware.database.ScreeningRepository;
import com.cinemamanagementsoftware.messaging.RabbitMQSender;
import cinemaManagementSoftware.impl.ScreeningImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    private final ScreeningRepository screeningRepository;
    private final RabbitMQSender rabbitMQSender;

    @Autowired
    public StatisticsController(ScreeningRepository screeningRepository, RabbitMQSender rabbitMQSender) {
        this.screeningRepository = screeningRepository;
        this.rabbitMQSender = rabbitMQSender;
    }

    // ✅ Send statistics about a screening (e.g., earnings) via RabbitMQ
    @PostMapping("/earnings")
    public String sendEarningsStatistics(@RequestBody Map<String, Object> statistics) {
        rabbitMQSender.send(statistics);
        return "📨 Earnings statistics sent to RabbitMQ!";
    }
}