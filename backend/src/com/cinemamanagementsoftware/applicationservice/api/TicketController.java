package com.cinemamanagementsoftware.applicationservice.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinemamanagementsoftware.applicationservice.handler.TicketHandler;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    private final ObjectMapper objectMapper;
    private final TicketHandler ticketHandler;
    
    @Autowired
    public TicketController(ObjectMapper objectMapper, TicketHandler ticketHandler) {
        this.objectMapper = objectMapper;
        
        this.ticketHandler = ticketHandler;
    }
    
    @PostMapping
    public ResponseEntity<String> createTicket(@RequestBody String jsonTicket) {
        try {

            // Deserialize JSON into a Map (extract only required fields)
            Map<String, Object> ticketMap = objectMapper.readValue(jsonTicket, new TypeReference<Map<String, Object>>() {});

            // Extract customerId, screeningId, seatId, and price
            if (!ticketMap.containsKey("customerId") || !ticketMap.containsKey("screeningId") || !ticketMap.containsKey("seatd") || !ticketMap.containsKey("price")) {
                return ResponseEntity.badRequest().body("{\"status\":\"error\",\"message\":\"Missing required ticket data!\"}");
            }

            Long customerId = Long.valueOf(ticketMap.get("customerId").toString());
            Long screeningId = Long.valueOf(ticketMap.get("screeningId").toString());
            Long seatId = Long.valueOf(ticketMap.get("seatId").toString());
            Double price = Double.valueOf(ticketMap.get("price").toString());

            // Call handler
            return ticketHandler.sendCreateTicketMessage(customerId, screeningId, seatId, price);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"status\":\"error\",\"message\":\"Error processing ticket: " + e.getMessage() + "\"}");
        }
    }
    
    @GetMapping("/{customerId}/screenings/{screeningId}/tickets")
    public ResponseEntity<?> getCustomerTicketsForScreening(@PathVariable Long customerId, @PathVariable Long screeningId) {
        return ticketHandler.getCustomerTicketsForScreening(customerId, screeningId);
    }
    
    @GetMapping("/screening/{screeningId}/tickets")
    public ResponseEntity<String> getTicketsForScreening(@PathVariable Long screeningId) {
        return ticketHandler.getTicketsForScreening(screeningId);
    }
    
    @GetMapping("/{customerId}/tickets")
    public ResponseEntity<String> getTicketsForCustomer(@PathVariable Long customerId) {
        return ticketHandler.getTicketsForCustomer(customerId);
    }
    
    @DeleteMapping("/{ticketId}")
    public ResponseEntity<String> deleteTicket(@PathVariable Long ticketId) {
        return ticketHandler.deleteTicket(ticketId);
    }
    
    @PatchMapping("/{ticketId}/book")
    public ResponseEntity<String> bookTicket(@PathVariable Long ticketId) {
        return ticketHandler.sendBookTicketMessage(ticketId);
    }
    
    @GetMapping("/screenings/{screeningId}/seats")
    public ResponseEntity<String> getSeatsForScreening(@PathVariable Long screeningId) {
        return ticketHandler.getSeatsForScreening(screeningId);
    }

    
    private String ensureEClassField(String jsonString) throws Exception {
        JsonNode jsonNode = objectMapper.readTree(jsonString);
        // If "eClass" is missing, we set it to the correct EClass URI from your Ecore
        if (!jsonNode.has("eClass")) {
            ((ObjectNode) jsonNode).put("eClass", 
               "http://www.example.org/cinemaManagementSoftware#//Ticket");
        }
        return objectMapper.writeValueAsString(jsonNode);
    }    

}
