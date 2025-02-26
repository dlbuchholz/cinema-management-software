package com.cinemamanagementsoftware.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue cinemaCreateQueue() {
        return new Queue("cinema.create", true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("cinemaExchange");
    }

    @Bean
    public Binding bindingCreate(Queue cinemaCreateQueue, TopicExchange exchange) {
        return BindingBuilder.bind(cinemaCreateQueue).to(exchange).with("cinema.create");
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }
}