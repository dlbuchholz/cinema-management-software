package com.cinemamanagementsoftware.applicationservice.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emfcloud.jackson.module.EMFModule;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;


import cinemaManagementSoftware.Ticket;
import cinemaManagementSoftware.Customer;

public class TicketHandler {
	private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    
	
	public TicketHandler(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
        
        this.objectMapper.registerModule(new EMFModule());
    }
	
	public ResponseEntity<String> sendCreateTicketMessage(Long customerId, Long screeningId, Long seatId, Double price) {
		try {
	        // Construct message payload
	        Map<String, Object> messagePayload = new HashMap<>();
	        messagePayload.put("customerId", customerId);
	        messagePayload.put("screeningId", screeningId);
	        messagePayload.put("seatId", seatId);
	        messagePayload.put("price", price);

	        // 🔹 Check if seat is already reserved
	        String seatCheckResponse = (String) rabbitTemplate.convertSendAndReceive("ticket.checkSeat", messagePayload);
	        if (seatCheckResponse != null && seatCheckResponse.contains("taken")) {
	            return ResponseEntity.status(HttpStatus.CONFLICT)
	                    .body("{\"status\":\"error\",\"message\":\"Seat is already booked for this screening.\"}");
	        }

	        // 🔹 Proceed with ticket creation
	        String response = (String) rabbitTemplate.convertSendAndReceive("ticket.create", messagePayload);
	        if (response != null) {
	            return ResponseEntity.ok(response);
	        } else {
	            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT)
	                    .body("{\"status\":\"error\",\"message\":\"Ticket Service Timeout\"}");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("{\"status\":\"error\",\"message\":\"Failed to create ticket: " + e.getMessage() + "\"}");
	    }
	}

	
	public ResponseEntity<String> getCustomerTicketsForScreening(Long customerId, Long screeningId) {
	    try {
	        // Construct message payload
	        Map<String, Object> messagePayload = new HashMap<>();
	        messagePayload.put("customerId", customerId);
	        messagePayload.put("screeningId", screeningId);

	        // Convert payload to JSON
	        String jsonMessage = objectMapper.writeValueAsString(messagePayload);

	        // Send message to RabbitMQ and wait for response
	        String response = (String) rabbitTemplate.convertSendAndReceive("ticket.get", jsonMessage);

	        // Handle response
	        if (response != null) {
	            return ResponseEntity.ok(response);
	        } else {
	            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT)
	                    .body("{\"status\":\"error\",\"message\":\"Ticket Service Timeout\"}");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("{\"status\":\"error\",\"message\":\"Failed to retrieve tickets: \"}");
	    }
	}

	
	public ResponseEntity<String> getTicketsForScreening(Long screeningId) {
	    try {
	        // Construct message payload
	        Map<String, Object> messagePayload = new HashMap<>();
	        messagePayload.put("screeningId", screeningId);

	        // Convert to JSON
	        String jsonMessage = objectMapper.writeValueAsString(messagePayload);

	        // Send message to RabbitMQ queue "ticket.getByScreening" and wait for response
	        String response = (String) rabbitTemplate.convertSendAndReceive("ticket.getByScreening", jsonMessage);

	        // Handle response
	        if (response != null) {
	            return ResponseEntity.ok(response);
	        } else {
	            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT)
	                    .body("{\"status\":\"error\",\"message\":\"Ticket Service Timeout\"}");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("{\"status\":\"error\",\"message\":\"Failed to retrieve tickets: \"}");
	    }
	}

	public ResponseEntity<String> getTicketsForCustomer(Long customerId) {
	    try {
	        // Construct message payload
	        Map<String, Object> messagePayload = new HashMap<>();
	        messagePayload.put("customerId", customerId);

	        // Convert to JSON
	        String jsonMessage = objectMapper.writeValueAsString(messagePayload);

	        // Send message to RabbitMQ queue "ticket.getByCustomer" and wait for response
	        String response = (String) rabbitTemplate.convertSendAndReceive("ticket.getByCustomer", jsonMessage);

	        // Handle response
	        if (response != null) {
	            return ResponseEntity.ok(response);
	        } else {
	            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT)
	                    .body("{\"status\":\"error\",\"message\":\"Ticket Service Timeout\"}");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("{\"status\":\"error\",\"message\":\"Failed to retrieve tickets: " + e.getMessage() + "\"}");
	    }
	}

	public ResponseEntity<String> deleteTicket(Long ticketId) {
	    try {
	        // Construct message payload
	        Map<String, Object> messagePayload = new HashMap<>();
	        messagePayload.put("ticketId", ticketId);

	        // Convert to JSON
	        String jsonMessage = objectMapper.writeValueAsString(messagePayload);

	        // Send message to RabbitMQ queue "ticket.delete" and wait for response
	        String response = (String) rabbitTemplate.convertSendAndReceive("ticket.delete", jsonMessage);

	        // Handle response
	        if (response != null) {
	            return ResponseEntity.ok(response);
	        } else {
	            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT)
	                    .body("{\"status\":\"error\",\"message\":\"Ticket Service Timeout\"}");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("{\"status\":\"error\",\"message\":\"Failed to delete ticket: " + e.getMessage() + "\"}");
	    }
	}
	
	public ResponseEntity<String> sendBookTicketMessage(Long ticketId) {
	    try {
	        // Construct message payload
	        Map<String, Object> messagePayload = new HashMap<>();
	        messagePayload.put("ticketId", ticketId);

	        // Convert to JSON
	        String jsonMessage = objectMapper.writeValueAsString(messagePayload);

	        // Send to RabbitMQ queue "ticket.book" and wait for response
	        String response = (String) rabbitTemplate.convertSendAndReceive("ticket.book", jsonMessage);

	        // Handle response
	        if (response != null) {
	            return ResponseEntity.ok(response);
	        } else {
	            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT)
	                    .body("{\"status\":\"error\",\"message\":\"Ticket Service Timeout\"}");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("{\"status\":\"error\",\"message\":\"Failed to update ticket: " + e.getMessage() + "\"}");
	    }
	}

	public ResponseEntity<String> getSeatsForScreening(Long screeningId) {
	    try {
	        // Send request to RabbitMQ
	        String response = (String) rabbitTemplate.convertSendAndReceive("ticket.getSeats", screeningId);

	        if (response != null) {
	            return ResponseEntity.ok(response);
	        } else {
	            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT)
	                    .body("{\"status\":\"error\",\"message\":\"Seat retrieval timeout\"}");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("{\"status\":\"error\",\"message\":\"Error fetching seats: " + e.getMessage() + "\"}");
	    }
	}

}
