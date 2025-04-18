package com.cinemamanagementsoftware.persistenceservice.consumers;

import com.cinemamanagementsoftware.persistenceservice.entities.SeatEntity;
import com.cinemamanagementsoftware.persistenceservice.entities.SeatingRowEntity;
import com.cinemamanagementsoftware.persistenceservice.repositories.SeatRepository;
import com.cinemamanagementsoftware.persistenceservice.repositories.SeatingRowRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SeatCommandConsumer {

    private final SeatRepository seatRepository;
    private final ObjectMapper objectMapper;
	private final SeatingRowRepository seatingRowRepository;
	private final RabbitTemplate rabbitTemplate;

    public SeatCommandConsumer(SeatRepository seatRepository,  SeatingRowRepository seatingRowRepository, RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.seatRepository = seatRepository;
        this.seatingRowRepository = seatingRowRepository;
        this.objectMapper = objectMapper;
        this.rabbitTemplate = rabbitTemplate;
    }

    // Fetch all seats
    @RabbitListener(queues = "seat.fetch.all")
    public String fetchAllSeats() {
        try {
            List<SeatEntity> seats = seatRepository.findAll();
            return objectMapper.writeValueAsString(seats);
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch seats\"}";
        }
    }

    // Fetch a seat by ID
    @RabbitListener(queues = "seat.fetch")
    public String fetchSeat(Long id) {
        try {
            Optional<SeatEntity> seat = seatRepository.findById(id);
            return seat.map(s -> {
                try {
                    return objectMapper.writeValueAsString(s);
                } catch (Exception e) {
                    return "{\"status\":\"error\",\"message\":\"Failed to serialize seat\"}";
                }
            }).orElse("{\"status\":\"error\",\"message\":\"Seat not found\"}");
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch seat\"}";
        }
    }

    @RabbitListener(queues = "seat.create")
    public String createSeat(Map<String, Object> requestData) {
        try {
            if (!requestData.containsKey("rowId")) {
                return "{\"status\":\"error\",\"message\":\"Missing required field: 'rowId'\"}";
            }

            Long rowId = Long.parseLong(requestData.get("rowId").toString());
            Optional<SeatingRowEntity> row = seatingRowRepository.findById(rowId);

            if (row.isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"Seating Row not found\"}";
            }

            SeatEntity newSeat = new SeatEntity();
            if (requestData.containsKey("seatNumber")) {
            	newSeat.setSeatNumber(Integer.parseInt(requestData.get("seatNumber").toString()));
            }
            newSeat.setRow(row.get());

            SeatEntity savedSeat = seatRepository.save(newSeat);
            rabbitTemplate.convertAndSend("event.seat.created", Map.of(
                    "id", savedSeat.getId(),
                    "rowId", rowId,
                    "seatNumber", savedSeat.getSeatNumber()
                ));
            return objectMapper.writeValueAsString(newSeat);
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to create Seat: " + e.getMessage() + "\"}";
        }
    }

    // Update an existing seat
    @RabbitListener(queues = "seat.update")
    public String updateSeat(Map<String, String> seatData) {
        try {
            Long id = Long.parseLong(seatData.get("id"));
            Optional<SeatEntity> seatOptional = seatRepository.findById(id);

            if (seatOptional.isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"Seat not found\"}";
            }

            SeatEntity seat = seatOptional.get();
            if (seatData.containsKey("seatNumber")) {
                seat.setSeatNumber(Integer.parseInt(seatData.get("seatNumber")));
            }

            seatRepository.save(seat);
            return "{\"status\":\"success\",\"message\":\"Seat updated\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Seat update failed\"}";
        }
    }

    // Delete a seat
    @RabbitListener(queues = "seat.delete")
    public String deleteSeat(Long id) {
        try {
            seatRepository.deleteById(id);
            rabbitTemplate.convertAndSend("event.seat.deleted", Map.of(
                    "id", id
                ));

            return "{\"status\":\"success\",\"message\":\"Seat deleted\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Seat deletion failed\"}";
        }
    }
}