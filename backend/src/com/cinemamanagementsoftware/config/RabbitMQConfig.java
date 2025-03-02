package com.cinemamanagementsoftware.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.amqp.rabbit.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Bean
	public Queue cinemaCreateQueue() {
	    return new Queue("cinema.create", true);
	}
	
	@Bean
	public Queue cinemaFetchQueue() {
	    return new Queue("cinema.fetch", true);
	}
	
	@Bean
	public Queue cinemaUpdateQueue() {
	    return new Queue("cinema.update", true);
	}
	
	@Bean
	public Queue cinemaDeleteQueue() {
	    return new Queue("cinema.delete", true);
	}
	
	@Bean
    public Queue registerQueue() { return new Queue("auth.register"); }

    @Bean
    public Queue loginQueue() { return new Queue("auth.login"); }

    @Bean
    public Queue validateTokenQueue() { return new Queue("auth.validateToken"); }
    
    @Bean
    public Queue customerCreateQueue() { return new Queue("customer.create", true); }
   
    @Bean
    public Queue customerFetchQueue() { return new Queue("customer.fetch", true); }
	
	@Bean
	public TopicExchange exchange() {
	    return new TopicExchange("cinemaExchange");
	}
	
	@Bean
	public Binding bindingCreate(@Qualifier("cinemaCreateQueue") Queue cinemaCreateQueue, TopicExchange exchange) {
	    return BindingBuilder.bind(cinemaCreateQueue).to(exchange).with("cinema.create");
	}
	
	@Bean
	public Binding bindingFetch(@Qualifier("cinemaFetchQueue") Queue cinemaFetchQueue, TopicExchange exchange) {
	    return BindingBuilder.bind(cinemaFetchQueue).to(exchange).with("cinema.fetch");
	}
	
	@Bean
	public Binding bindingUpdate(@Qualifier("cinemaUpdateQueue") Queue cinemaUpdateQueue, TopicExchange exchange) {
	    return BindingBuilder.bind(cinemaUpdateQueue).to(exchange).with("cinema.update");
	}
	
	@Bean
	public Binding bindingDelete(@Qualifier("cinemaDeleteQueue") Queue cinemaDeleteQueue, TopicExchange exchange) {
	    return BindingBuilder.bind(cinemaDeleteQueue).to(exchange).with("cinema.delete");
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