package com.cinemamanagementsoftware.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

/**
 * Utility class for generating sequential IDs for entities that 
 * are not using Hibernate's automatic ID generation.
 * 
 * Since Ecore-generated objects do not support `@GeneratedValue`, this class 
 * ensures unique and sequential ID assignment for all entities stored in MySQL.
 * 
 * It queries the database to determine the highest existing ID and increments it.
 */

@Component
public class IdGenerator {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Long getNextId(Class<?> entityClass) {
        String entityName = entityClass.getSimpleName();
        Long maxId = (Long) entityManager.createQuery(
                "SELECT COALESCE(MAX(e.id), 0) FROM " + entityName + " e")
                .getSingleResult();
        return maxId + 1;
    }
}
