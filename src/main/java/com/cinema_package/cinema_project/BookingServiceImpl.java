package com.cinema_package.cinema_project;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService{
    private BookingRepository bookingRepository;

    public BookingServiceImpl (BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override 
    public Booking createBooking(Booking booking) {
        Booking newBooking = bookingRepository.save(booking);
        return newBooking;
    }

    @Override 
    public List<Booking> getBooking() {
        List<Booking> allBookings = bookingRepository.findAll();
        return (List<Booking>) allBookings;
    }
}
