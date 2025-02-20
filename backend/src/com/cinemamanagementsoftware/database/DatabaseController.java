package com.cinemamanagementsoftware.database;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

import java.util.Collection;

import org.neo4j.ogm.config.Configuration;
import cinemaManagementSoftware.Cinema;
import cinemaManagementSoftware.impl.CinemaImpl;

public class DatabaseController {
    private final SessionFactory sessionFactory;
    private final Session session;

    public DatabaseController() {
        Configuration config = new Configuration.Builder()
                .uri("bolt://localhost:7687")
                .credentials("neo4j", "lobster-child-atomic-canvas-infant-6060")
                .build();
        sessionFactory = new SessionFactory(config, "cinemaManagementSoftware");
        session = sessionFactory.openSession();
    }
    
    /**
     * Tests the Neo4J connection by running a simple query.
     */
    public Boolean testConnection() {
        try {
            String query = "RETURN 'Neo4J Verbindung erfolgreich!' AS message";
            String result = session.queryForObject(String.class, query, java.util.Collections.emptyMap());
            System.out.println(result);
            return true;
        } catch (Exception e) {
            System.out.println("Neo4J connection failed: " + e.getMessage());
            e.printStackTrace();
        }
        
        return false;
    }
    
    /**
     * Executes a Cypher Query.
     */
    public void executeQuery(String query) {
        Session session = sessionFactory.openSession();
        try {
            System.out.println("Executing Cypher query: " + query);
            session.query(query, java.util.Collections.emptyMap());
            System.out.println("✅ Query executed successfully.");
        } catch (Exception e) {
            System.out.println("❌ Query execution failed: " + e.getMessage());
        }
    }
    
    public Session getSession() {
    	return session;
    }

    public void close() {
        sessionFactory.close();
    }
}
