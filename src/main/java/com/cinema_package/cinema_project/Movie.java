package com.cinema_package.cinema_project;
//import jakarta.persistence.*;
//import org.springframework.format.annotation.DateTimeFormat;
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

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "movie")
public class Movie {
    @Id
    @Column(name = "id")
    private int id;

    @NotBlank(message = "First name is mandatory")
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

    @Column(name = "location")
    private String location;

    @Range(min = 50, max = 200, message = "Number of Seats should be between 50 and 200")
    @Column(name = "totalseats")
    private int totalSeats;

    @Range(min = 50, max = 200, message = "Number of Seats should be between 50 and 200")
    @Column(name = "availablesetas")
    private int availableSeats;

    @Range(min = 0, max = 200, message = "Price should be between 0 and 200")
    @Column(name = "price")
    private int price;

    public Movie() {}

    //private static final Logger logger = (Logger) LoggerFactory.getLogger(CinemaProjectApplication.class);

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Booking> booking;
  
}
