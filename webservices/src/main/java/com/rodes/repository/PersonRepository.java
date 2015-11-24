package com.rodes.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import com.rodes.domain.Person;

public interface PersonRepository extends GraphRepository<Person> {

	Person findByName(String name);
	
	@Query("MATCH (p:Person) WHERE p.name =~ ('(?i).*'+{name}+'.*')  RETURN p")
	Collection<Person> findByNameContaining(@Param("name") String name);
	
}
