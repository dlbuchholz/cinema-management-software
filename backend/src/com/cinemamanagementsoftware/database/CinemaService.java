package com.cinemamanagementsoftware.database;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.config.Configuration;
import cinemaManagementSoftware.Cinema;

public class CinemaService {
    private final SessionFactory sessionFactory;

    public CinemaService() {
        Configuration config = new Configuration.Builder()
                .uri("bolt://localhost:7687")
                .credentials("neo4j", "lobster-child-atomic-canvas-infant-6060")
                .build();
        sessionFactory = new SessionFactory(config, "model");
    }

    public void createCinema(Cinema cinema) {
        Session session = sessionFactory.openSession();
        session.save(cinema);
        System.out.println("Cinema created: " + cinema.getName());
    }

    public void close() {
        sessionFactory.close();
    }
}
