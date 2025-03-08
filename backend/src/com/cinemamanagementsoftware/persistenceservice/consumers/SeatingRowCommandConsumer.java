package com.cinemamanagementsoftware.persistenceservice.consumers;

import com.cinemamanagementsoftware.persistenceservice.entities.CinemaEntity;
import com.cinemamanagementsoftware.persistenceservice.entities.CinemaHallEntity;
import com.cinemamanagementsoftware.persistenceservice.entities.SeatingRowEntity;
import com.cinemamanagementsoftware.persistenceservice.repositories.CinemaHallRepository;
import com.cinemamanagementsoftware.persistenceservice.repositories.SeatingRowRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import cinemaManagementSoftware.Category;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SeatingRowCommandConsumer {

	private final CinemaHallRepository hallRepository;
	private final SeatingRowRepository seatingRowRepository;
	private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public SeatingRowCommandConsumer(SeatingRowRepository rowRepository, CinemaHallRepository hallRepository, RabbitTemplate rabbitTemplate,  ObjectMapper objectMapper) {
        this.hallRepository = hallRepository;
		this.seatingRowRepository = rowRepository;
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    // Fetch all seating rows
    @RabbitListener(queues = "seatingRow.fetch.all")
    public String fetchAllSeatingRows() {
        try {
            List<SeatingRowEntity> rows = seatingRowRepository.findAllWithSeats();
            return objectMapper.writeValueAsString(rows);
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch seating rows\"}";
        }
    }

    // Fetch a seating row by ID
    @RabbitListener(queues = "seatingRow.fetch")
    public String fetchSeatingRow(Long id) {
        try {
            Optional<SeatingRowEntity> row = seatingRowRepository.findByIdWithSeats(id);
            return row.map(r -> {
                try {
                    return objectMapper.writeValueAsString(r);
                } catch (Exception e) {
                    return "{\"status\":\"error\",\"message\":\"Failed to serialize seating row\"}";
                }
            }).orElse("{\"status\":\"error\",\"message\":\"Seating row not found\"}");
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to fetch seating row\"}";
        }
    }

    @RabbitListener(queues = "seatingRow.create")
    public String createSeatingRow(Map<String, Object> requestData) {
        try {
            if (!requestData.containsKey("cinemaHallId") || !requestData.containsKey("category")) {
                return "{\"status\":\"error\",\"message\":\"Missing required fields: 'cinemaHallId' and 'category'\"}";
            }

            SeatingRowEntity newRow = new SeatingRowEntity();
            Long hallId = Long.valueOf(requestData.get("cinemaHallId").toString());
            
            Optional<CinemaHallEntity> hallOptional = hallRepository.findById(hallId);
            newRow.setCinemaHall(hallOptional.get());
            //newRow.setCategory(Category.valueOf(requestData.get("category").toString()));

            seatingRowRepository.save(newRow);
            return objectMapper.writeValueAsString(newRow);
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Failed to create Seating Row: " + e.getMessage() + "\"}";
        }
    }

    // Update an existing seating row
    @RabbitListener(queues = "seatingRow.update")
    public String updateSeatingRow(Map<String, String> rowData) {
        try {
            Long id = Long.parseLong(rowData.get("id"));
            Optional<SeatingRowEntity> rowOptional = seatingRowRepository.findById(id);

            if (rowOptional.isEmpty()) {
                return "{\"status\":\"error\",\"message\":\"Seating row not found\"}";
            }

            SeatingRowEntity row = rowOptional.get();
            if (rowData.containsKey("rowNr")) {
                row.setrowNr(Integer.parseInt(rowData.get("rowNr")));
            }

            seatingRowRepository.save(row);
            return "{\"status\":\"success\",\"message\":\"Seating row updated\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Seating row update failed\"}";
        }
    }

    // Delete a seating row
    @RabbitListener(queues = "seatingRow.delete")
    public String deleteSeatingRow(Long id) {
        try {
            seatingRowRepository.deleteById(id);
            return "{\"status\":\"success\",\"message\":\"Seating row deleted\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\",\"message\":\"Seating row deletion failed\"}";
        }
    }
}