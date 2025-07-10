package com.cinema_package.cinema_project;

// Custom exception class to handle cases when a movie is not found
public class MovieNotFoundException extends RuntimeException {

    // Constructor that takes a movie ID and passes a custom error message to the superclass
    MovieNotFoundException(Integer id) {
        // Call to the parent class (RuntimeException) constructor with a custom message
        super("Unable to find movie with id: " + id);
    }
}