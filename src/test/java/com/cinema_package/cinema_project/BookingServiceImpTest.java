package com.cinema_package.cinema_project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

// import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookingServiceImpTest {
    
    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    BookingServiceImpl bookingService;

    @Test
    public void createBookingTest() {

        // 1. SETUP
        Booking booking = Booking.builder().booking_id(100).ticket_number(2).build();

        // mock the save method 
        when((bookingRepository.save(booking))).thenReturn(booking);

        // 2. EXECUTE
        Booking savedBooking = bookingService.createBooking(booking);

        // 3. ASSERT
        assertEquals(booking, savedBooking, "The saved booking should be the same as the new customer.");

        // also verify that the save method of the customer repository is called once only.
        verify(bookingRepository, times(1)).save(booking);
    }

}
