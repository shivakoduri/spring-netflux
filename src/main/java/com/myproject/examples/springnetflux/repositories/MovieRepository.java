package com.myproject.examples.springnetflux.repositories;

import com.myproject.examples.springnetflux.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
