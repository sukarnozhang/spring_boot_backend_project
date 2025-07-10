package com.cinema_package.cinema_project;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Booking entities.
 * 
 * Extends JpaRepository to provide CRUD operations and 
 * database interaction methods for Booking objects,
 * where the primary key type is Integer.
 */
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
