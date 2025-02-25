package com.cinemamanagementsoftware.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RabbitMQSender {

    private final RabbitTemplate rabbitTemplate;
    private final String EXCHANGE_NAME = "cinemaExchange";
    private final String ROUTING_KEY = "cinema.statistics";

    @Autowired
    public RabbitMQSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(Map<String, Object> statistics) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, statistics);
        System.out.println("📨 Sent statistics to RabbitMQ: " + statistics);
    }
}