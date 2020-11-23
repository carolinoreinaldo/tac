package com.tac;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.tac.fakes.BDPerson;
import com.tac.models.Person;

class PersonBDTest {

	@Test
	void testInsert() {
		BDPerson.clearBd();
		BDPerson.save(new Person("José Alves", 26));
		List<Person> personList = BDPerson.getAll();
		
		assertEquals(1, personList.size());
	}
	
	@Test
	void testFind() {
		BDPerson.clearBd();
		Person person = BDPerson.save(new Person("José Alves", 26));
		Person peobleBd = BDPerson.findById(person.getId());
		
		assertNotNull(peobleBd);
	}
	
	@Test
	void testRemove() {
		BDPerson.clearBd();
		Person p1 = BDPerson.save(new Person("José Alves", 26));
		Person p2 = BDPerson.save(new Person("Maria da Silva", 36));
		
		//testando a quantidade de registro do banco
		assertEquals(2, BDPerson.getAll().size());
		
		BDPerson.remove(p2);
		
		//testando a quantidade de registro do banco
		assertEquals(1, BDPerson.getAll().size());
		
		BDPerson.remove(p1);
		
		//testando a quantidade de registro do banco
		assertEquals(0, BDPerson.getAll().size());
	}
	
	@Test
	public void testUpdate() {
		BDPerson.clearBd();
		Person p1 = BDPerson.save(new Person("José Alves", 26));
				
		Person p2 = BDPerson.findById(p1.getId());
		
		p2.setName("Alberto");
		p2.setAge(50);
		
		BDPerson.update(p2);
		
		Person p3 = BDPerson.findById(p2.getId());
		
		assertEquals("Alberto", p3.getName());
		assertEquals(50, p3.getAge());
		
		
	}
	
	public static List<Person> createPeoples() {
		List<Person> list = new ArrayList<Person>();
		
		list.add(new Person("José Alves", 26));
		list.add(new Person("Maria Alcântara", 30));
		list.add(new Person("Teresa Cristina Figueiredo", 35));
		
		return list;
	}

}
