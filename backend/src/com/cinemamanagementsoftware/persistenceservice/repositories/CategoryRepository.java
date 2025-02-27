package com.cinemamanagementsoftware.persistenceservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemamanagementsoftware.persistenceservice.entities.CategoryEntity;


@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
