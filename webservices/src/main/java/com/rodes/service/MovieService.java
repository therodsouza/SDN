package com.rodes.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rodes.domain.Movie;
import com.rodes.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	@Transactional(readOnly = true)
	public Iterable<Movie> findAllMovies() {
		return repository.findAll();
	}

	private Map<String, Object> toD3Format(Iterator<Map<String, Object>> result) {
		List<Map<String, Object>> nodes = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> rels = new ArrayList<Map<String, Object>>();
		int i = 0;
		while (result.hasNext()) {
			Map<String, Object> row = result.next();
			nodes.add(map("title", row.get("movie"), "label", "movie"));
			int target = i;
			i++;
			for (Object name : (Collection) row.get("cast")) {
				Map<String, Object> actor = map("title", name, "label", "actor");
				int source = nodes.indexOf(actor);
				if (source == -1) {
					nodes.add(actor);
					source = i++;
				}
				rels.add(map("source", source, "target", target));
			}
		}
		return map("nodes", nodes, "links", rels);
	}

	private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		result.put(key1, value1);
		result.put(key2, value2);
		return result;
	}

	public Map<String, Object> graph(int limit) {
		Iterator<Map<String, Object>> result = repository.graph(limit).iterator();
		return toD3Format(result);
	}

}
