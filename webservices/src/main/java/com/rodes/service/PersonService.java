package com.rodes.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodes.domain.Person;
import com.rodes.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	public Collection<Person> findByNameContaining(String name) {
		return this.repository.findByNameContaining(name);
	}

}
