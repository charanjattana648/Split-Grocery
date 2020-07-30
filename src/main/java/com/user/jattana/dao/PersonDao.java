package com.user.jattana.dao;

import java.util.List;

import com.user.jattana.model.Person;

public interface PersonDao {

	boolean addPerson(Person person);
	
	List<Person> getAllPerson();
		
	boolean deletePerson(int id);
	
	int numberOfPersons();
}
