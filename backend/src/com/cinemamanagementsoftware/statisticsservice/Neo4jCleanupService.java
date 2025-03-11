package com.cinemamanagementsoftware.statisticsservice;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class Neo4jCleanupService {

    private final Driver neo4jDriver;

    public Neo4jCleanupService(Driver neo4jDriver) {
        this.neo4jDriver = neo4jDriver;
    }

    @SuppressWarnings("deprecation")
	@PostConstruct
    public void cleanDatabaseOnStartup() {
        try (Session session = neo4jDriver.session()) {
            System.out.println("🧹 Cleaning Neo4j database...");
            session.writeTransaction(tx -> {
                tx.run("MATCH (n) DETACH DELETE n"); // Delete all nodes and relationships
                return null;
            });
            System.out.println("✅ Neo4j database cleaned successfully!");
        } catch (Exception e) {
            System.err.println("❌ Failed to clean Neo4j database: " + e.getMessage());
        }
    }
}