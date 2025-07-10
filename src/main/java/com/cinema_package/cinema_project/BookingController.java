package com.cinema_package.cinema_project;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * REST controller for managing Booking-related endpoints.
 * Handles HTTP requests related to creating and retrieving bookings.
 */
@RestController
@RequestMapping("/booking")
public class BookingController {

    // Logger instance for logging controller actions
    private static final Logger logger = LoggerFactory.getLogger(CinemaProjectApplication.class);

    // Booking service to handle business logic
    private final BookingService bookingService;

    
    // Constructor-based dependency injection of BookingService.
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

     // POST endpoint to create a new booking.
     // booking Booking object received from the request body
     // ResponseEntity containing the newly created booking and HTTP status 201
    @PostMapping("")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking newBooking = bookingService.createBooking(booking);
        logger.info("🟢 Booking created successfully");
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }

     // GET endpoint to retrieve all bookings.
     // return ResponseEntity containing a list of bookings and HTTP status 200
    @GetMapping("")
    public ResponseEntity<List<Booking>> getBooking() {
        List<Booking> bookings = bookingService.getBooking();
        logger.info("🟢 Fetched bookings successfully");
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
}
