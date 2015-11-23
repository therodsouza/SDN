package com.rodes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rodes.domain.Movie;
import com.rodes.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;

	@Transactional(readOnly=true)
	public Iterable<Movie> findAllMovies() {
		return repository.findAll();
	}
	
	public Movie insertDefault() {
		
		Movie movie = new Movie();
		
		movie.setName("The Matrix");
		return this.repository.save(movie);
		
	}
}
