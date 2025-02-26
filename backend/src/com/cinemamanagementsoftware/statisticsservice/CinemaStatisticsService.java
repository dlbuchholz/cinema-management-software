package com.cinemamanagementsoftware.statisticsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.neo4j.ogm.session.Session;
import java.util.List;
//import cinemaManagementSoftware.CinemaStatistics;

@Service
public class CinemaStatisticsService {
    private final GraphDatabaseController graphDbController;

    @Autowired
    public CinemaStatisticsService(GraphDatabaseController neo4JController) {
        this.graphDbController = neo4JController;
    }
/*
    public void saveStatistics(CinemaStatistics stats) {
        graphDbController.save(stats);
    }

    public List<CinemaStatistics> getAllStatistics() {
        return (List<CinemaStatistics>) graphDbController.getSession().loadAll(CinemaStatistics.class);
    }*/
}
