package com.cinemamanagementsoftware.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Movie Queues
    @Bean
    public Queue movieCreateQueue() { return new Queue("movie.create", true); }

    @Bean
    public Queue movieFetchQueue() { return new Queue("movie.fetch", true); }

    @Bean
    public Queue movieFetchAllQueue() { return new Queue("movie.fetch.all", true); }

    @Bean
    public Queue movieUpdateQueue() { return new Queue("movie.update", true); }

    @Bean
    public Queue movieDeleteQueue() { return new Queue("movie.delete", true); }
    
    @Bean
    public Queue movieSearchQueue() { return new Queue("movie.search", true); }

    @Bean
    public Binding bindingMovieSearch(@Qualifier("movieSearchQueue") Queue queue, TopicExchange movieExchange) {
        return BindingBuilder.bind(queue).to(movieExchange).with("movie.search");
    }

    // Cinema Queues
    @Bean
    public Queue cinemaCreateQueue() { return new Queue("cinema.create", true); }

    @Bean
    public Queue cinemaFetchQueue() { return new Queue("cinema.fetch", true); }

    @Bean
    public Queue cinemaUpdateQueue() { return new Queue("cinema.update", true); }

    @Bean
    public Queue cinemaDeleteQueue() { return new Queue("cinema.delete", true); }

    // Authentication & Customer Queues
    @Bean
    public Queue registerQueue() { return new Queue("auth.register"); }

    @Bean
    public Queue loginQueue() { return new Queue("auth.login"); }

    @Bean
    public Queue logoutQueue() { return new Queue("auth.logout"); }

    @Bean
    public Queue validateTokenQueue() { return new Queue("auth.validateToken"); }

    @Bean
    public Queue customerCreateQueue() { return new Queue("customer.create", true); }

    @Bean
    public Queue customerFetchQueue() { return new Queue("customer.fetch", true); }

    @Bean
    public Queue customerFetchByIdQueue() { return new Queue("customer.fetchById", true); }

    // Exchanges
    @Bean
    public TopicExchange exchange() { return new TopicExchange("cinemaExchange"); }

    @Bean
    public TopicExchange movieExchange() { return new TopicExchange("movieExchange"); }

    // Movie Bindings
    @Bean
    public Binding bindingMovieCreate(@Qualifier("movieCreateQueue") Queue queue, TopicExchange movieExchange) {
        return BindingBuilder.bind(queue).to(movieExchange).with("movie.create");
    }

    @Bean
    public Binding bindingMovieFetch(@Qualifier("movieFetchQueue") Queue queue, TopicExchange movieExchange) {
        return BindingBuilder.bind(queue).to(movieExchange).with("movie.fetch");
    }

    @Bean
    public Binding bindingMovieFetchAll(@Qualifier("movieFetchAllQueue") Queue queue, TopicExchange movieExchange) {
        return BindingBuilder.bind(queue).to(movieExchange).with("movie.fetch.all");
    }

    @Bean
    public Binding bindingMovieUpdate(@Qualifier("movieUpdateQueue") Queue queue, TopicExchange movieExchange) {
        return BindingBuilder.bind(queue).to(movieExchange).with("movie.update");
    }

    @Bean
    public Binding bindingMovieDelete(@Qualifier("movieDeleteQueue") Queue queue, TopicExchange movieExchange) {
        return BindingBuilder.bind(queue).to(movieExchange).with("movie.delete");
    }

    // Cinema Bindings
    @Bean
    public Binding bindingCinemaCreate(@Qualifier("cinemaCreateQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("cinema.create");
    }

    @Bean
    public Binding bindingCinemaFetch(@Qualifier("cinemaFetchQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("cinema.fetch");
    }

    @Bean
    public Binding bindingCinemaUpdate(@Qualifier("cinemaUpdateQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("cinema.update");
    }

    @Bean
    public Binding bindingCinemaDelete(@Qualifier("cinemaDeleteQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("cinema.delete");
    }

    // JSON Message Converter
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