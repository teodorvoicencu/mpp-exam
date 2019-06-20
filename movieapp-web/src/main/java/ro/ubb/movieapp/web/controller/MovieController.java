package ro.ubb.movieapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.movieapp.core.model.Movie;
import ro.ubb.movieapp.core.service.MovieService;
import ro.ubb.movieapp.web.converter.ActorConverter;
import ro.ubb.movieapp.web.converter.MovieConverter;
import ro.ubb.movieapp.web.dto.MovieDto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    private final MovieService movieService;


    private final MovieConverter movieConverter;

    private final ActorConverter actorConverter;

    @Autowired
    public MovieController(MovieService movieService, MovieConverter movieConverter, ActorConverter actorConverter) {
        this.movieService = movieService;
        this.movieConverter = movieConverter;
        this.actorConverter = actorConverter;
    }

    @GetMapping
    public Set<MovieDto> getMoviesByYear(@RequestParam(name = "year") Integer year,
                                         @RequestParam(name = "lessThan") Boolean lesThan) {
        return this.movieConverter.convertModelsToDtos(this.movieService.getMoviesByYear(year, lesThan));
    }

    @GetMapping(value = "/cast")
    public Set<MovieDto> getMoviesWithActorsByYear(@RequestParam(name = "year") Integer year,
                                                   @RequestParam(name = "lessThan") Boolean lesThan) {
        List<Movie> movieList = this.movieService.getMoviesWithActorsByYear(year, lesThan);
        Set<MovieDto> movies = new HashSet<>();
        for (Movie aMovieList : movieList) {
            MovieDto movieDto = movieConverter.convertModelToDto(aMovieList);
            movieDto.setActors(actorConverter.convertModelsToDtos(aMovieList.getActors()));
            movies.add(movieDto);
        }
        return movies;
    }
}
