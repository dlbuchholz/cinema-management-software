package com.cinemamanagementsoftware.applicationservice.api;

import com.cinemamanagementsoftware.database.ScreeningService;
import cinemaManagementSoftware.impl.ScreeningImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API controller for managing screenings.
 * 
 * This class provides HTTP endpoints to interact with Screening entities,
 * allowing external clients to create, retrieve, and delete screenings.
 * 
 * It follows RESTful design principles and integrates with the ScreeningService.
 */

@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {
    private final ScreeningService screeningService;

    @Autowired
    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @GetMapping
    public List<ScreeningImpl> getAllScreenings() {
        return screeningService.getAllScreenings();
    }

    @GetMapping("/{id}")
    public ScreeningImpl getScreeningById(@PathVariable Long id) {
        return screeningService.getScreeningById(id);
    }

    @PostMapping
    public ScreeningImpl createScreening(@RequestBody ScreeningImpl screening) {
        return screeningService.createScreening(screening);
    }

    @DeleteMapping("/{id}")
    public void deleteScreening(@PathVariable Long id) {
        screeningService.deleteScreening(id);
    }
}
