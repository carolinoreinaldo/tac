package com.tac.repositories;

import java.util.List;

import com.tac.models.Person;

public interface PersonRepository {

	List<Person> findAll();

	Person save(Person p);
	
	Person update(Person p);
	
	void remove(Person p);
	
	Person findById(Long id);

}
