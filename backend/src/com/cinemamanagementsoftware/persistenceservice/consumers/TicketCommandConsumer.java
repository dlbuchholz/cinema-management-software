package com.cinemamanagementsoftware.persistenceservice.consumers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cinemamanagementsoftware.persistenceservice.entities.CustomerEntity;
import com.cinemamanagementsoftware.persistenceservice.entities.ScreeningEntity;
import com.cinemamanagementsoftware.persistenceservice.entities.SeatEntity;
import com.cinemamanagementsoftware.persistenceservice.entities.SeatingRowEntity;
import com.cinemamanagementsoftware.persistenceservice.entities.TicketEntity;
import com.cinemamanagementsoftware.persistenceservice.repositories.CustomerRepository;
import com.cinemamanagementsoftware.persistenceservice.repositories.ScreeningRepository;
import com.cinemamanagementsoftware.persistenceservice.repositories.SeatRepository;
import com.cinemamanagementsoftware.persistenceservice.repositories.SeatingRowRepository;
import com.cinemamanagementsoftware.persistenceservice.repositories.TicketRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TicketCommandConsumer {
	@Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ScreeningRepository screeningRepository;
    
    @Autowired 
    SeatRepository seatRepository;
    
    @Autowired
    SeatingRowRepository seatingrowRepository;

    @Autowired
    private ObjectMapper objectMapper; // JSON processor

    @RabbitListener(queues = "ticket.checkSeat")
    public String checkSeatAvailability(String jsonRequest) {
        try {
            Map<String, Object> requestMap = objectMapper.readValue(jsonRequest, new TypeReference<>() {});

            Long screeningId = Long.valueOf(requestMap.get("screeningId").toString());
            Long seatId = Long.valueOf(requestMap.get("seatId").toString());

            // 🔹 Query DB for existing ticket with the same screening & seat
            boolean seatTaken = ticketRepository.existsByScreeningIdAndSeatId(screeningId, seatId);

            if (seatTaken) {
                return "{\"status\":\"error\",\"message\":\"Seat is already taken\"}";
            } else {
                return "{\"status\":\"success\",\"message\":\"Seat is available\"}";
            }
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Error checking seat: " + e.getMessage() + "\"}";
        }
    }

    @RabbitListener(queues = "ticket.create")
    public String processCreateTicket(Map<String, Object> requestMap) {  
        try {
            // Extract values from the received Map
            Long customerId = Long.valueOf(requestMap.get("customerId").toString());
            Long screeningId = Long.valueOf(requestMap.get("screeningId").toString());
            Long seatId = Long.valueOf(requestMap.get("seatId").toString());
            Double price = Double.valueOf(requestMap.get("price").toString());

            // Check if seat is already booked
            if (ticketRepository.existsByScreeningIdAndSeatId(screeningId, seatId)) {
                return "{\"status\":\"error\",\"message\":\"Seat is already taken\"}";
            }

            // Fetch related entities
            Optional<CustomerEntity> customerOpt = customerRepository.findById(customerId);
            Optional<ScreeningEntity> screeningOpt = screeningRepository.findById(screeningId);
            Optional<SeatEntity> seatOpt = seatRepository.findById(seatId);

            if (customerOpt.isEmpty() || screeningOpt.isEmpty() || seatOpt.isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"Invalid customer, screening, or seat ID!\"}";
            }

            // Create and save the ticket
            TicketEntity newTicket = new TicketEntity();
            newTicket.setOwner(customerOpt.get());
            newTicket.setScreening(screeningOpt.get());
            newTicket.setSeat(seatOpt.get());
            newTicket.setPrice(price);
            newTicket.setBookedStatus(false); // Default to reserved

            ticketRepository.save(newTicket);
            return "{\"status\":\"success\",\"message\":\"Ticket created successfully!\"}";

        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to create ticket: " + e.getMessage() + "\"}";
        }
    }

    
    @RabbitListener(queues = "ticket.get")
    public String processGetTickets(String jsonRequest) {
        try {
            // Deserialize request payload
            Map<String, Object> requestMap = objectMapper.readValue(jsonRequest, new TypeReference<Map<String, Object>>() {});
            
            Long customerId = Long.valueOf(requestMap.get("customerId").toString());
            Long screeningId = Long.valueOf(requestMap.get("screeningId").toString());

            // Fetch tickets	
            List<TicketEntity> tickets = ticketRepository.findByCustomerIdAndScreeningId(customerId, screeningId);

            // Convert to JSON and return
            return objectMapper.writeValueAsString(tickets);
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch tickets: " + e.getMessage() + "\"}";
        }
    }
    
    @RabbitListener(queues = "ticket.getByScreening")
    public String processGetTicketsByScreening(String jsonRequest) {
        try {
            // Deserialize request payload
            Map<String, Object> requestMap = objectMapper.readValue(jsonRequest, new TypeReference<Map<String, Object>>() {});
            
            Long screeningId = Long.valueOf(requestMap.get("screeningId").toString());

            // Fetch all tickets for the given screening
            List<TicketEntity> tickets = ticketRepository.findByScreeningId(screeningId);

            // Convert to JSON and return
            return objectMapper.writeValueAsString(tickets);
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch tickets: " + e.getMessage() + "\"}";
        }
    }
    
    @RabbitListener(queues = "ticket.getByCustomer")
    public String processGetTicketsByCustomer(String jsonRequest) {
        try {
            // Deserialize request payload
            Map<String, Object> requestMap = objectMapper.readValue(jsonRequest, new TypeReference<Map<String, Object>>() {});
            
            Long customerId = Long.valueOf(requestMap.get("customerId").toString());

            // Fetch all tickets for the given customer
            List<TicketEntity> tickets = ticketRepository.findByCustomerId(customerId);

            // Convert to JSON and return
            return objectMapper.writeValueAsString(tickets);
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch tickets: " + e.getMessage() + "\"}";
        }
    }
    
    @RabbitListener(queues = "ticket.delete")
    public String processDeleteTicket(String jsonRequest) {
        try {
            // Deserialize request payload
            Map<String, Object> requestMap = objectMapper.readValue(jsonRequest, new TypeReference<Map<String, Object>>() {});
            Long ticketId = Long.valueOf(requestMap.get("ticketId").toString());

            // Fetch ticket from DB
            Optional<TicketEntity> ticketOpt = ticketRepository.findById(ticketId);
            if (ticketOpt.isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"Ticket not found.\"}";
            }

            TicketEntity ticket = ticketOpt.get();

            // Prevent deletion if ticket is booked
            if (Boolean.TRUE.equals(ticket.getBookedStatus())) {
                return "{\"status\":\"error\",\"message\":\"Cannot delete a booked ticket.\"}";
            }

            // Delete ticket
            ticketRepository.delete(ticket);
            return "{\"status\":\"success\",\"message\":\"Ticket deleted successfully.\"}";

        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to delete ticket: " + e.getMessage() + "\"}";
        }
    }
    
    @RabbitListener(queues = "ticket.book")
    public String processBookTicket(String jsonRequest) {
        try {
            // Deserialize request payload
            Map<String, Object> requestMap = objectMapper.readValue(jsonRequest, new TypeReference<Map<String, Object>>() {});
            Long ticketId = Long.valueOf(requestMap.get("ticketId").toString());

            // Fetch ticket from DB
            Optional<TicketEntity> ticketOpt = ticketRepository.findById(ticketId);
            if (ticketOpt.isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"Ticket not found.\"}";
            }

            TicketEntity ticket = ticketOpt.get();

            // Prevent unbooking
            if (Boolean.TRUE.equals(ticket.getBookedStatus())) {
                return "{\"status\":\"error\",\"message\":\"Ticket is already booked.\"}";
            }

            // Update status
            ticket.setBookedStatus(true);
            ticketRepository.save(ticket);

            return "{\"status\":\"success\",\"message\":\"Ticket successfully booked.\"}";

        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to update ticket: " + e.getMessage() + "\"}";
        }
    }
    
    @RabbitListener(queues = "ticket.getSeats")
    public String getSeatsForScreening(String screeningId) {
        try {
            Long screeningIdLong = Long.parseLong(screeningId);

            // 🔹 Fetch the screening
            Optional<ScreeningEntity> screeningOpt = screeningRepository.findById(screeningIdLong);
            if (screeningOpt.isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"Screening not found\"}";
            }
            ScreeningEntity screening = screeningOpt.get();

            // 🔹 Fetch seating rows for the cinema hall where this screening is taking place
            List<SeatingRowEntity> seatingRows = seatingrowRepository.findByCinemaHallId(screening.getCinemaHall().getId());

            // 🔹 Collect all seats from these rows
            List<SeatEntity> allSeats = new ArrayList<>();
            for (SeatingRowEntity row : seatingRows) {
                allSeats.addAll(row.getSeats());
            }

            // 🔹 Fetch all taken seats (reserved or booked)
            List<TicketEntity> takenTickets = ticketRepository.findByScreeningId(screeningIdLong);
            Set<Long> takenSeatIds = takenTickets.stream()
                    .map(ticket -> ticket.getSeat().getId())
                    .collect(Collectors.toSet());

            // 🔹 Construct response JSON
            List<Map<String, Object>> seatResponse = new ArrayList<>();
            for (SeatEntity seat : allSeats) {
                Map<String, Object> seatInfo = new HashMap<>();
                seatInfo.put("id", seat.getId());
                seatInfo.put("seatNumber", seat.getSeatNumber());
                seatInfo.put("rowId", seat.getRow().getId());
                seatInfo.put("rowNumber", seat.getRow().getNr());
                seatInfo.put("category", seat.getRow().getCategory().getId()); // Assuming category ID is needed
                seatInfo.put("isTaken", takenSeatIds.contains(seat.getId())); // Mark if seat is taken
                seatResponse.add(seatInfo);
            }

            return objectMapper.writeValueAsString(seatResponse);

        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch seats: " + e.getMessage() + "\"}";
        }
    }


}
