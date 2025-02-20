package com.cinemamanagementsoftware;

import com.cinemamanagementsoftware.database.CinemaService;
import cinemaManagementSoftware.*;

public class Main {

	    public static void main(String[] args) {
	        CinemaService cinemaService = new CinemaService();
	        CinemaManagementSoftwareFactory factory = CinemaManagementSoftwareFactory.eINSTANCE;

	        Cinema cinema = factory.createCinema();
	        cinema.setName("CineMega ABC");
	        cinema.setLocation("Hannover");

	        cinemaService.createCinema(cinema);

	        cinemaService.close();
	    }

}