package com.cinemamanagementsoftware.database;

import java.util.Collection;

import org.neo4j.ogm.session.Session;

import cinemaManagementSoftware.Cinema;
import cinemaManagementSoftware.impl.CinemaImpl;

// Neo4J Persistence layer
public class CinemaService {
	private final Session session;
	
	public CinemaService(DatabaseController dbController) {
        this.session = dbController.getSession();  // Use the shared session
    }
	
	 /**
     * Saves the cinema (updates if it already exists).
     */
    public void save(Cinema cinema) {
        System.out.println("Saving cinema: " + cinema.getName() + " to database...");

        try {
            session.save(cinema);
            System.out.println("Cinema saved successfully!");
        } catch (Exception e) {
            System.out.println("Error while saving Cinema: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Loads the cinema from the database. Returns null if no cinema exists.
     */
    public Cinema load() {
        Collection<CinemaImpl> cinemas = session.loadAll(CinemaImpl.class);
        return cinemas.isEmpty() ? null : cinemas.iterator().next();
    }
    
    public Cinema getCinemaById(Long id) {
        return session.load(Cinema.class, id);
    }

    public void delete(Cinema cinema) {
        session.delete(cinema);
        System.out.println("❌ Cinema deleted: " + cinema.getName());
    }

    public boolean exists() {
        return !session.loadAll(CinemaImpl.class).isEmpty();
    }

}
