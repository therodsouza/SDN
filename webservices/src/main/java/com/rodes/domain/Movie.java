package com.rodes.domain;

import java.util.Collection;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Movie {

	@GraphId
	Long id;

	String title;

	int released;
	String tagline;

	@Relationship(type = "ACTED_IN", direction = Relationship.INCOMING)
	List<Role> roles;

	// end::movie[]

	public Movie() {
	}

	public String getTitle() {
		return title;
	}

	public int getReleased() {
		return released;
	}

	public String getTagline() {
		return tagline;
	}

	public Collection<Role> getRoles() {
		return roles;
	}
}
