package com.rodes.domain;

import java.util.Collection;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "ACTED_IN")
public class Role {
	@GraphId
	Long id;
	Collection<String> roles;
	
	@StartNode
	Person person;
	
	@EndNode
	Movie movie;

	public Role() {
	}

	public Collection<String> getRoles() {
		return roles;
	}

	public Person getPerson() {
		return person;
	}

	public Movie getMovie() {
		return movie;
	}
}
