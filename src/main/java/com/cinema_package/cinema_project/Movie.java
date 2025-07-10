package com.cinema_package.cinema_project;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

/**
 * Entity class representing a Movie in the cinema database.
 * This class is mapped to the 'movie' table in the database.
 */
@Entity
@Getter
@Setter
@Table(name = "movie")  // Specifies the table name for this entity
public class Movie {

    // Unique identifier for each movie
    @Id
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Movie title is mandatory")
    @Column(name = "title")
    private String title;

    @Column(name = "director")
    private String director;

    @Column(name = "description")
    private String description;

    @Column(name = "genre")
    private String genre;

    @Column(name = "date")
    private LocalDate date;

    // Location where the movie is being screened
    @Column(name = "location")  // Maps to 'location' column in the table
    private String location;

    // Total number of seats in the movie theater for the specific movie
    @Range(min = 50, max = 200, message = "Number of seats should be between 50 and 200")  // Validation on range
    @Column(name = "totalseats")  // Maps to 'totalseats' column in the table
    private int totalSeats;

    // Number of available seats for booking
    @Range(min = 50, max = 200, message = "Number of available seats should be between 50 and 200")  // Validation on range
    @Column(name = "availableseats")  // Maps to 'availableseats' column in the table
    private int availableSeats;

    // Ticket price for the movie
    @Range(min = 0, max = 200, message = "Price should be between 0 and 200")  // Validation on range
    @Column(name = "price")  // Maps to 'price' column in the table
    private int price;

    // Default constructor (used by JPA for instantiating entities)
    public Movie() {}

    // One-to-many relationship with the Booking entity
    // A movie can have multiple bookings associated with it
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)  // Cascade all operations to related bookings
    private List<Booking> booking;  // List of bookings for the movie
}
