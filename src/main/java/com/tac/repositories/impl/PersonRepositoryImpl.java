package com.tac.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tac.fakes.BDPerson;
import com.tac.models.Person;
import com.tac.repositories.PersonRepository;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

	@Override
	public List<Person> findAll() {
		return BDPerson.getAll();
		//PeopleFake.createPeoples();
	}

	@Override
	public Person save(Person people) {
		return BDPerson.save(people);
	}

	@Override
	public Person update(Person p) {
		return BDPerson.update(p);
	}

	@Override
	public void remove(Person p) {
		BDPerson.remove(p);
	}

	@Override
	public Person findById(Long id) {
		return BDPerson.findById(id);
	}
}
