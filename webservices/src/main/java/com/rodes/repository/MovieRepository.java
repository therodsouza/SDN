package com.rodes.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.rodes.domain.Movie;

public interface MovieRepository extends GraphRepository<Movie> {

	
}
