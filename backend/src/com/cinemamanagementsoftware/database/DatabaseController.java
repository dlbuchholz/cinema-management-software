package com.cinemamanagementsoftware.database;

import org.springframework.stereotype.Component;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


//Use a relational database for storing all cinema-related entities 
//(e.g., Cinema, CinemaHall, CinemaOwner).
//
//For all statistics, Neo4J is used (GraphDatabaseController)

@Component
public class DatabaseController {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Transactional
    public void save(Object entity) {
        entityManager.persist(entity);
    }

    public <T> T find(Class<T> entityClass, Long id) {
        return entityManager.find(entityClass, id);
    }

    @Transactional
    public void delete(Object entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
}
