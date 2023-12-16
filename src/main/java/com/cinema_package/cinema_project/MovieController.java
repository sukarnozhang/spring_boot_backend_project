package com.cinema_package.cinema_project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/movie")
public class MovieController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(CinemaProjectApplication.class);
    private final MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        List<Movie> allMovies = movieService.getAllMovies();
        logger.info("🟢 Get All Movies Done");
        return allMovies;
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Integer id) {
        Movie foundMovie = movieService.getMoviesById(id);
        logger.info("🟢 Get Movies with id Done");
        return foundMovie;
    }

    @GetMapping("/search")
    public List<Movie> searchGenre(@RequestParam String genre) {
        List<Movie> foundGenre = movieService.getMoviesByGenre(genre);
        logger.info("🟢 Search Movies by genre Done");
        return foundGenre;
    }

    @PostMapping("")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie newMovie = movieService.createMovie(movie);
        logger.info("🟢 Create movie Done");
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity <Movie> deleteMovie(@PathVariable Integer id) {
        // movieService.deleteMovie(id);
        // logger.info("🟢 Delete Movies Done");
        // return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        try {
            movieService.deleteMovie(id);
            logger.info("🟢 delete movies Done");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (MovieNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @PutMapping("/{id}")
    public ResponseEntity <Movie> updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
        Movie updatedMovie = movieService.updateMovie(id, movie);
        logger.info("🟢 update movies Done");
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }


}