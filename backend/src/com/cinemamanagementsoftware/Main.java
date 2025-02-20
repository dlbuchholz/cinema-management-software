package com.cinemamanagementsoftware;

import com.cinemamanagementsoftware.database.CinemaService;
import com.cinemamanagementsoftware.database.DatabaseController;
import cinemaManagementSoftware.*;

public class Main {

	    public static void main(String[] args) {
	        DatabaseController dbController = new DatabaseController();
	        
	        // Only start backend if Neo4J database is accessible and responding
	        if(dbController.testConnection()) {
		        CinemaManagementSoftwareFactory factory = CinemaManagementSoftwareFactory.eINSTANCE;
		     
		        // Create or Load the Cinema
		        CinemaService cinemaService = new CinemaService(dbController);
		        Cinema cinema = cinemaService.load();
		        if (cinema == null) {
	
			        cinema = factory.createCinema();
			        cinema.setName("CineMega ABC");
			        cinema.setLocation("Hannover");
		
			        cinemaService.save(cinema);
		        } else {
		        	System.out.println("✅ Cinema data successfully loaded from Neo4J database!");
		        }
		        
		        // Start Interactive Console
		        ConsoleInterface console = new ConsoleInterface(cinemaService, cinema, dbController);
		        console.start();
	        }
	        
	        dbController.close();
	    }

}