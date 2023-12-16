package com.cinema_package.cinema_project;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="booking")
@Getter
@Setter
@Builder
public class Booking {
    @Id
    @Column(name="booking_id")
    private Integer booking_id;

    @Column(name="ticket_number")
    private Integer ticket_number;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="movie_id", referencedColumnName="id")
    private Movie movie;

    public Booking() {}

    public Booking(Integer booking_id, Integer ticket_number, Movie movie) {
        this();
        this.booking_id = booking_id;
        this.ticket_number = ticket_number;
  
    }

}
