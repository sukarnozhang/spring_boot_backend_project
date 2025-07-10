package com.cinema_package.cinema_project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity class representing a booking in the cinema system.
 * Maps to the "booking" table in the database.
 */
@Entity
@Table(name = "booking")
@Getter
@Setter
public class Booking {

    // Primary key for Booking entity.
    // Maps to the "booking_id" column in the "booking" table.
    // setBooking_id() and getBooking_id() 
    @Id
    @Column(name = "booking_id")
    private Integer booking_id;

    // Number of tickets booked.
    // Maps to the "ticket_number" column in the "booking" table.
    @Column(name = "ticket_number")
    private Integer ticket_number;

    
    // Many-to-one relationship to Movie entity.
    // From movie_id in booking to id in movie
    // Indicates which movie this booking is associated with.
    // JsonBackReference prevents infinite recursion during JSON serialization.
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    
    // Default no-argument constructor required by JPA.
    public Booking() {}


     // Constructor to create a Booking instance with given parameters.
     // booking_id    Unique identifier for the booking
     // ticket_number Number of tickets in the booking
     // movie         Associated Movie entity
    public Booking(Integer booking_id, Integer ticket_number, Movie movie) {
        this();
        this.booking_id = booking_id;
        this.ticket_number = ticket_number;
        this.movie = movie;
    }
}
