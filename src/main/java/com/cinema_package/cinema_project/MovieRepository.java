
package com.cinema_package.cinema_project;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByGenre (String genre);
}