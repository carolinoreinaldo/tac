package com.tac.services;

import java.util.List;

import com.tac.models.Person;

public interface PersonService {

	List<Person> getAll();

	Person save(Person p);

	Person update(Person p);
	
	void remove(Person p);
	
	void remove(Long id);
	
	Person getById(Long id);

}
