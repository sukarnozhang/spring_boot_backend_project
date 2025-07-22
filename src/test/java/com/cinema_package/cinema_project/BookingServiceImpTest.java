package com.cinema_package.cinema_project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Unit tests for BookingServiceImpl using Mockito to mock dependencies.
 */
@SpringBootTest
public class BookingServiceImpTest {
    
    @Mock
    private BookingRepository bookingRepository;  // Mock BookingRepository dependency

    @InjectMocks
    private BookingServiceImpl bookingService;    // Service under test, with mocks injected

    /**
     * Test the creation of a booking.
     * Verifies that the booking is saved correctly and that the repository save method is called once.
     */
    @Test
    public void createBookingTest() {

        // 1. Setup: create a booking object to be saved
        Booking booking = Booking.builder()
                                 .booking_id(100)
                                 .ticket_number(2)
                                 .build();

        // Mock behavior: when save is called with booking, return booking
        when(bookingRepository.save(booking)).thenReturn(booking);

        // 2. Execute: call the service method
        Booking savedBooking = bookingService.createBooking(booking);

        // 3. Assert: check returned booking equals the input booking
        assertEquals(booking, savedBooking, "The saved booking should match the original booking.");

        // Verify that save was called exactly once with the booking object
        verify(bookingRepository, times(1)).save(booking);
    }
}
