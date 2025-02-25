package com.cinemamanagementsoftware.messaging;

//import com.cinemamanagementsoftware.database.MongoDBStatisticsRepository;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RabbitMQConsumer {
/*
    private final statisticsRepository statisticsRepository;

    @Autowired
    public RabbitMQConsumer(statisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    @RabbitListener(queues = "cinemaStatisticsQueue")
    public void receiveMessage(Map<String, Object> statistics) {
        System.out.println("📥 Received earnings statistics from RabbitMQ: " + statistics);
        statisticsRepository.save(statistics);
    }*/
}