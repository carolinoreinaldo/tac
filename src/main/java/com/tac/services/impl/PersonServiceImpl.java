package com.tac.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tac.models.Person;
import com.tac.repositories.PersonRepository;
import com.tac.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonRepository peopleRepository;
	
	public PersonServiceImpl(PersonRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}

	@Override
	public List<Person> getAll() {
		return peopleRepository.findAll();
	}

	@Override
	public Person save(Person people) {
		return peopleRepository.save(people);
	}

	@Override
	public Person update(Person p) {
		return peopleRepository.update(p);
	}

	@Override
	public void remove(Person p) {
		peopleRepository.remove(p);
	}
	@Override
	public void remove(Long id) {
		Person personToBeRemoved = this.getById(id);
		this.remove(personToBeRemoved);
	}

	@Override
	public Person getById(Long id) {
		return peopleRepository.findById(id);
	}
}
