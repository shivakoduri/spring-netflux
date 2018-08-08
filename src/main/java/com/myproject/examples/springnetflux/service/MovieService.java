package com.myproject.examples.springnetflux.service;

import com.myproject.examples.springnetflux.domain.Movie;
import com.myproject.examples.springnetflux.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    Flux<MovieEvent> events(String movieId);

    Mono<Movie> getMovieById(String id);

    Flux<Movie> getAllMovies();

}
