package com.cinemamanagementsoftware.database;

import cinemaManagementSoftware.CinemaManagementSoftwareFactory;
import cinemaManagementSoftware.impl.CinemaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer for handling business logic related to Cinema entities.
 * 
 * This class interacts with the CinemaRepository to fetch, create, update, 
 * and delete cinemas while ensuring proper ID assignment and persistence.
 * 
 * It integrates Ecore-generated objects with the Hibernate ORM framework.
 */

@Service
public class CinemaService {
    private final CinemaRepository cinemaRepository;
    private final IdGenerator idGenerator;

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
        this.idGenerator = new IdGenerator();
    }

    public List<CinemaImpl> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    public CinemaImpl getCinemaById(Long id) {
        return cinemaRepository.findById(id).orElse(null);
    }

    public CinemaImpl createCinema(String name, String location) {
        CinemaImpl cinema = (CinemaImpl) CinemaManagementSoftwareFactory.eINSTANCE.createCinema();
        cinema.setId(idGenerator.getNextId(CinemaImpl.class)); // Assign sequential ID
        cinema.setName(name);
        cinema.setLocation(location);
        return cinemaRepository.save(cinema);
    }

    public void deleteCinema(Long id) {
        cinemaRepository.deleteById(id);
    }
}
