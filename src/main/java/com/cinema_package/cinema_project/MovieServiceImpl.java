package com.cinema_package.cinema_project;
//import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> allMovies = movieRepository.findAll();
        return allMovies;
    }

    @Override
    public Movie getMoviesById(Integer id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        List<Movie> foundGenre = movieRepository.findByGenre(genre);
        return foundGenre;
    }

    @Override
    public Movie createMovie(Movie movie) {
        Movie newMovie = movieRepository.save(movie);
        return newMovie;
    }

    @Override
    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);

    }

    @Override
    public Movie updateMovie(Integer id, Movie movie){
        Movie movieToUpdate = movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid movie ID: " + id));;
        
        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setDirector(movie.getDirector());
        movieToUpdate.setDescription(movie.getDescription());
        movieToUpdate.setGenre(movie.getGenre());
        movieToUpdate.setDate(movie.getDate());
        movieToUpdate.setLocation(movie.getLocation());
        movieToUpdate.setTotalSeats(movie.getTotalSeats());
        movieToUpdate.setTitle(movie.getTitle());

        return movieRepository.save(movieToUpdate);

    }



}
