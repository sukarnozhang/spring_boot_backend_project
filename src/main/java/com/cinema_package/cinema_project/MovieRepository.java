package com.cinema_package.cinema_project;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Movie entity.
 * Extends JpaRepository to provide CRUD operations on Movie objects.
 */
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    
    /**
     * To query movies by genre (custom query needed)
     */
    List<Movie> findByGenre(String genre);
}
