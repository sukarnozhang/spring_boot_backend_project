package com.cinema_package.cinema_project;

import java.util.List;

public interface BookingService {

    // Creates a new booking.
    Booking createBooking(Booking booking);

     // Retrieves all existing bookings.
    List<Booking> getBooking();
}
