package com.cinemamanagementsoftware;

import com.cinemamanagementsoftware.applicationservice.ConsoleInterface;

import cinemaManagementSoftware.Cinema;
import cinemaManagementSoftware.CinemaManagementSoftwarePackage;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.cinemamanagementsoftware.config",                 			// Configurations (RabbitMQ, etc.)
        "com.cinemamanagementsoftware.applicationservice",
        "com.cinemamanagementsoftware.applicationservice.handler",  
        "com.cinemamanagementsoftware.authenticationservice",  			 // Security Service
        "com.cinemamanagementsoftware.demoservice",						// Demo Service
        "com.cinemamanagementsoftware.persistenceservice",      		// Persistence Layer (JPA)
        "com.cinemamanagementsoftware.persistenceservice.consumers", 	// RabbitMQ Consumers
        "com.cinemamanagementsoftware.persistenceservice.repositories", // MySQL Repositories
        "com.cinemamanagementsoftware.statisticsservice"        		// Neo4j & Graph Database Statistics
})
@EnableJpaRepositories(basePackages = "com.cinemamanagementsoftware.persistenceservice.repositories")
@EntityScan("com.cinemamanagementsoftware.persistenceservice.entities") 
public class Main {

    public static void main(String[] args) {
        // Start Spring Boot application
    	ApplicationContext context = SpringApplication.run(Main.class, args);
    	
    	// Get RabbitMQ template
        RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
        // Register Ecore Package
        EPackage.Registry.INSTANCE.put(CinemaManagementSoftwarePackage.eNS_URI, CinemaManagementSoftwarePackage.eINSTANCE);
        //CinemaManagementSoftwarePackage.eINSTANCE.eClass(); // Ensure package is registered
        //Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
        
        // Start the interactive console interface	
        ConsoleInterface consoleInterface = new ConsoleInterface(rabbitTemplate);
        consoleInterface.start();
        
        // Shutdown Spring Boot after execution
        SpringApplication.exit(context);
        System.exit(0);
    }
}
