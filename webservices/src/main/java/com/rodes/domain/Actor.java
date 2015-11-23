package com.rodes.domain;

import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Actor {
	
	@GraphId
	private Long id;
	
	@Property(name="name")
	public String name;
	
	public Actor() {
		
	}
	
	public Actor(String name) {
		this.name = name;
	}
	
	@Relationship(type="ACTED_IN", direction=Relationship.OUTGOING)
	public Set<Movie> filmography;

}
