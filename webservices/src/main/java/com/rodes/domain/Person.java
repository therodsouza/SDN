package com.rodes.domain;

import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Person {
	@GraphId
	Long id;

	private String name;
	
	private int born;

	@Relationship(type = "ACTED_IN")
	List<Movie> movies;

	public Person() {
	}

	public String getName() {
		return name;
	}

	public int getBorn() {
		return born;
	}

	public List<Movie> getMovies() {
		return movies;
	}
}
