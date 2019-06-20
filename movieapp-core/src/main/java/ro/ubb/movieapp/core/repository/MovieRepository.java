package ro.ubb.movieapp.core.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import ro.ubb.movieapp.core.model.Movie;

import java.util.List;

/**
 * author: radu
 */
public interface MovieRepository extends MovieAppRepository<Movie, Long> {
    List<Movie> findByYearIsGreaterThan(Integer year);

    List<Movie> findByYearIsLessThanEqual(Integer year);

    @EntityGraph(value = "movieActors")
    List<Movie> findMoviesByYearIsGreaterThan(Integer year);

    @EntityGraph(value = "movieActors")
    List<Movie> findMoviesByYearIsLessThanEqual(Integer year);
}
