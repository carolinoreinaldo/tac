package com.tac.fakes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tac.exceptions.IdAlreadyExistException;
import com.tac.exceptions.ObjectNotFoundException;
import com.tac.models.Person;

public class BDPerson {

	private static Long id = 1L;
	private static List<Person> personList = new ArrayList<Person>();

	public static Person save(Person person) {
		validatePeopleIdAlreadyExist(person);
		person.setId(id);
		id += 1;
		personList.add(person);
		return person.getClone();
	}

	public static Person update(Person person) {
		validatePeopleIdIsNull(person);
		//get person from list without clone
		Person personToUpdate = getPeople(person);
		personToUpdate.setName(person.getName());
		personToUpdate.setAge(person.getAge());
		//get cloned person from list
		return findById(personToUpdate.getId());
	}

	

	public static void remove(Person person) {
		validatePeopleIdIsNull(person);
		personList.remove(person);
	}

	public static List<Person> getAll() {
		return Collections.unmodifiableList(personList);
	}

	public static Person findById(Long personId) {
		for (Person person : personList) {
			if (person.getId().equals(personId)) {
				return person.getClone();
			}
		}
		throw new ObjectNotFoundException("People not found for ID : " + personId);
	}
	
	private static void validatePeopleIdIsNull(Person person) {
		if (person.getId() == null) {
			throw new ObjectNotFoundException("Peaple not found in BD");
		}
	}
	
	private static void validatePeopleIdAlreadyExist(Person person) {
		if (person.getId() != null) {
			throw new IdAlreadyExistException("People Already have Id");
		}
	}
	
	public static void clearBd() {
		personList.clear();
	}
	
	private static Person getPeople(Person p) {
		for (Person person : personList) {
			if (p.getId().equals(person.getId())) {
				return person;
			}
		}
		throw new ObjectNotFoundException("Peaple not found in BD");
	}
}
