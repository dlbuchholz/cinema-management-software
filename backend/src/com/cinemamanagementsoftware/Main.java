package com.cinemamanagementsoftware;

import com.cinemamanagementsoftware.database.CinemaService;
import cinemaManagementSoftware.Cinema;

public class Main {

	    public static void main(String[] args) {
	        CinemaService cinemaService = new CinemaService();

	        Cinema cinema = new Cinema();
	        cinema.setName("CineMaxx");
	        cinema.setLocation("Berlin");

	        cinemaService.createCinema(cinema);

	        cinemaService.close();
	    }

}
