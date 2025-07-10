package com.cinema_package.cinema_project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller class responsible for handling HTTP requests related to movies.
 * It exposes RESTful APIs for CRUD operations on Movie entities.
 */
@RestController
@RequestMapping("/movie") 
public class MovieController {

    // Logger for logging request details and operations
    private static final Logger logger = LoggerFactory.getLogger(CinemaProjectApplication.class);

    // Service layer injected for movie-related business logic
    private final MovieService movieService;

    // Constructor for MovieController, takes MovieService as a dependency
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Endpoint to retrieve all movies.
    @GetMapping
    public List<Movie> getAllMovies() {
        List<Movie> allMovies = movieService.getAllMovies();  // Fetch all movies from service
        logger.info("🟢 Get All Movies Done");  // Log the operation
        return allMovies;  // Return the list of movies
    }

    // Endpoint to retrieve a movie by its ID.
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Integer id) {
        Movie foundMovie = movieService.getMoviesById(id);  
        logger.info("🟢 Get Movie with id={} Done", id);
        return foundMovie;  
    }

    // Endpoint to search movies by genre.
    @GetMapping("/search")
    public List<Movie> searchGenre(@RequestParam String genre) {
        List<Movie> foundGenre = movieService.getMoviesByGenre(genre);  // Search movies by genre
        logger.info("🟢 Search Movies by genre={} Done", genre);  // Log the search by genre
        return foundGenre;  
    }

    // Endpoint to create a new movie.
    @PostMapping("")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie newMovie = movieService.createMovie(movie);  // Create new movie via service
        logger.info("🟢 Create Movie Done");  
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);  // Return response with created movie and status
    }

    // Endpoint to delete a movie by its ID.
    @DeleteMapping("{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Integer id) {
        try {
            movieService.deleteMovie(id);  
            logger.info("🟢 Delete Movie with id={} Done", id); 
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        } catch (MovieNotFoundException e) {
            logger.error("🔴 Movie with id={} not found", id);  
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    // Endpoint to update an existing movie.
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
        Movie updatedMovie = movieService.updateMovie(id, movie);  // Update movie via service
        logger.info("🟢 Update Movie with id={} Done", id); 
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK); 
    }
}