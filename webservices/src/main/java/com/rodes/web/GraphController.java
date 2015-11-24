package com.rodes.web;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rodes.domain.Movie;
import com.rodes.service.MovieService;

@RestController
public class GraphController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/graph")
	public Map<String, Object> graph(@RequestParam(value = "limit", required = false) Integer limit) {
		return movieService.graph(limit == null ? 100 : limit);
	}
	
	@RequestMapping("/movies")
	public Collection<Movie> findByTitleContaining(@RequestParam(value = "title", required = true) String title) {
		return movieService.findByTitleContaining(title);
	}
}
