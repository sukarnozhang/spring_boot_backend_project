package com.cinema_package.cinema_project;

import java.util.List;

public interface BookingService {
    //CREATE
    Booking createBooking(Booking booking);

    //READ
    List<Booking> getBooking();
    
}
