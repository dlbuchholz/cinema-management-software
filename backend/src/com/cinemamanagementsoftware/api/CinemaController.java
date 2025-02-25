package com.cinemamanagementsoftware.api;

import com.cinemamanagementsoftware.database.CinemaService;
import cinemaManagementSoftware.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST API controller for managing Cinema entities.
 * 
 * This class exposes HTTP endpoints that allow clients to create, retrieve, 
 * and delete cinemas while integrating with the CinemaService for database operations.
 * 
 * It follows standard REST API conventions.
 */

@RestController
@RequestMapping("/api/cinemas")
public class CinemaController {
    private final CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping
    public List<Cinema> getAllCinemas() {
    	return cinemaService.getAllCinemas().stream()
                .map(cinema -> (Cinema) cinema) // Casting to `Cinema` interface
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Cinema getCinemaById(@PathVariable Long id) {
        return cinemaService.getCinemaById(id);
    }

    @PostMapping
    public void createCinema(@RequestBody String name, String location) {
        cinemaService.createCinema(name, location);
    }

    @DeleteMapping("/{id}")
    public void deleteCinema(@PathVariable Long id) {
        Cinema cinema = cinemaService.getCinemaById(id);
        if (cinema != null) {
            cinemaService.deleteCinema(id);
        }
    }
}
