package com.cinema_package.cinema_project;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/booking")
public class BookingController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(CinemaProjectApplication.class);
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    //CREATE
    @PostMapping("")
    public ResponseEntity<Booking> createBooking (@RequestBody Booking booking) {
        Booking newBooking = bookingService.createBooking(booking);
        logger.info("🟢 create booking Done");
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }

    //READ
    @GetMapping("")
    public ResponseEntity<List<Booking>> getBooking () {
        List<Booking> getBooking = bookingService.getBooking();
        logger.info("🟢 read booking Done");
        return new ResponseEntity<>(getBooking, HttpStatus.OK);
    }
}
