package com.cinemamanagementsoftware.database;

import cinemaManagementSoftware.impl.ScreeningImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for managing Screening entities.
 * 
 * This class is responsible for handling screenings, including their creation,
 * retrieval, and deletion, while ensuring proper database persistence.
 * 
 * It leverages Spring Data JPA for automatic query execution.
 */


@Service
public class ScreeningService {
    private final ScreeningRepository screeningRepository;
    private final IdGenerator idGenerator;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public ScreeningService(ScreeningRepository screeningRepository, IdGenerator idGenerator) {
        this.screeningRepository = screeningRepository;
        this.idGenerator = idGenerator;
    }

    public List<ScreeningImpl> getAllScreenings() {
        return screeningRepository.findAll();
    }

    public ScreeningImpl getScreeningById(Long id) {
        return screeningRepository.findById(id).orElse(null);
    }

    @Transactional
    public ScreeningImpl createScreening(ScreeningImpl screening) {
        //screening.setId(idGenerator.getNextId(ScreeningImpl.class)); // Assign a sequential ID
        return screeningRepository.save(screening);
    }

    @Transactional
    public void deleteScreening(Long id) {
        screeningRepository.deleteById(id);
    }
}
