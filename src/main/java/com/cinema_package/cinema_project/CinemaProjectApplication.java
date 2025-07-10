package com.cinema_package.cinema_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

/**
 * Main entry point for the Cinema Project Spring Boot application.
 * This class also serves as a REST controller.
 */
@SpringBootApplication
@RestController
public class CinemaProjectApplication {

    public static void main(String[] args) {
        // Starts the Spring Boot application
        SpringApplication.run(CinemaProjectApplication.class, args);
    }


}
