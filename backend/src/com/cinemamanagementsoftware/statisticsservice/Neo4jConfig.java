package com.cinemamanagementsoftware.statisticsservice;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Neo4jConfig {

    private static final String NEO4J_URI = "bolt://localhost:7687";
    private static final String NEO4J_USER = "neo4j";
    private static final String NEO4J_PASSWORD = "lobster-child-atomic-canvas-infant-6060";

    /** Neo4j Driver Bean */
    @Bean
    public Driver neo4jDriver() {
        return GraphDatabase.driver(NEO4J_URI, AuthTokens.basic(NEO4J_USER, NEO4J_PASSWORD));
    }

    /** Neo4j Session Bean (for direct queries) */
    @Bean
    public Session neo4jSession(Driver driver) {
        return driver.session();
    }
}
  