package com.cinema_package.cinema_project;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Service implementation for handling booking operations.
 * This class provides business logic for creating and retrieving bookings.
 */
@Service
public class BookingServiceImpl implements BookingService {

    // Repository (communication with database) used for accessing booking data from the database
    private final BookingRepository bookingRepository;

    /**
     * Constructor for dependency injection of BookingRepository.
     */
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    /**
     * Creates and saves a new booking to the database.
     * Implement method from parent class, mismatch methods name will trigger compile error
     */
    @Override 
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    /**
     * Retrieves all bookings from the database.
     */
    @Override 
    public List<Booking> getBooking() {
        return bookingRepository.findAll();
    }
}
