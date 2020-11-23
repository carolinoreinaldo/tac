package com.tac.fakes;

import java.util.ArrayList;
import java.util.List;

import com.tac.models.Person;

public class PeopleFake {

	public static List<Person> createPeoples() {
		List<Person> list = new ArrayList<Person>();
		
		list.add(new Person("José Alves", 26));
		list.add(new Person("Maria Alcântara", 30));
		list.add(new Person("Teresa Cristina Figueiredo", 35));
		
		return list;
	}
}
