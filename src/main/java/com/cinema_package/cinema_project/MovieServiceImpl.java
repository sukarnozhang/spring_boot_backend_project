package com.cinema_package.cinema_project;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Service implementation for managing movies.
 * This class provides the business logic for creating, retrieving,
 * updating, and deleting movies in the cinema project.
 */
@Service
public class MovieServiceImpl implements MovieService {
    
    private final MovieRepository movieRepository; // Movie repository for database operations

    // Constructor injection for MovieRepository
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    
    // since it's implementing Movie Service
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMoviesById(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        // Fetching movies by genre from the repository
        return movieRepository.findByGenre(genre);
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Movie updateMovie(Integer id, Movie movie) {
        Movie movieToUpdate = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie ID: " + id));
        
        // Updating movie fields with new values
        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setDirector(movie.getDirector());
        movieToUpdate.setDescription(movie.getDescription());
        movieToUpdate.setGenre(movie.getGenre());
        movieToUpdate.setDate(movie.getDate());
        movieToUpdate.setLocation(movie.getLocation());
        movieToUpdate.setTotalSeats(movie.getTotalSeats());

        // Saving the updated movie back to the repository
        return movieRepository.save(movieToUpdate);
    }
}
