	package com.tac.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tac.models.Person;
import com.tac.services.PersonService;

@RestController
@RequestMapping("/tac")
public class PersonController {
	
	private PersonService personService;
	
	public PersonController(PersonService peopleService) {
		this.personService = peopleService;
	}

	@GetMapping("/persons")
	public ResponseEntity<List<Person>> all() {
		List<Person> all = personService.getAll();
		return httpOk(all);
	}
	
	@GetMapping("/persons/{personId}")
	public ResponseEntity<Person> getById(@PathVariable(value = "personId") long id) {
		Person p = personService.getById(id);
		return httpOk(p);
	}
	
	@PostMapping("/persons")
	public ResponseEntity<Person> save(@RequestBody Person person) {
		Person p = personService.save(person);
		return httpOk(p);
	}
	
	@PutMapping("/persons/{personId}")
	public ResponseEntity<Person> update(@RequestBody Person p) {
		Person person = personService.update(p);
		return httpOk(person);
	}
	
	@DeleteMapping("persons/{personId}")
	public ResponseEntity<Person> remove(@PathVariable(value = "personId") long id) {
		personService.remove(id);
		return httpOk();
	}
	
	private ResponseEntity<Person> httpOk(Person p) {
		return new ResponseEntity<Person>(p, HttpStatus.OK);
	}
	
	private ResponseEntity<List<Person>> httpOk(List<Person> list) {
		return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
	}
	
	private ResponseEntity<Person> httpOk() {
		return new ResponseEntity<Person>(HttpStatus.OK);
	}
}
