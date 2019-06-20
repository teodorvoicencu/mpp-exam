package ro.ubb.movieapp.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.movieapp.core.model.Movie;
import ro.ubb.movieapp.core.repository.MovieRepository;

import java.util.List;

/**
 * author: radu
 */


@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getMoviesByYear(int year, boolean lessThan) {
        if (lessThan)
            return this.movieRepository.findByYearIsLessThanEqual(year);
        else
            return this.movieRepository.findByYearIsGreaterThan(year);
    }

    @Override
    public List<Movie> getMoviesWithActorsByYear(int year, boolean lessThan) {
        if (lessThan)
            return this.movieRepository.findMoviesByYearIsLessThanEqual(year);
        else
            return this.movieRepository.findMoviesByYearIsGreaterThan(year);
    }

    @Override
    public void deleteActor(Long movieId, Long actorId) {
        throw new RuntimeException("not yet implemented");
    }
}
