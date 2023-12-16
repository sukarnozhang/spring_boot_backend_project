package com.cinema_package.cinema_project;
import java.util.List;


public interface MovieService {
    List<Movie> getAllMovies();
    Movie getMoviesById(Integer id);
    List<Movie> getMoviesByGenre(String genre);
    Movie createMovie(Movie movie);
    void deleteMovie (Integer id);
    Movie updateMovie(Integer id, Movie movie);
}