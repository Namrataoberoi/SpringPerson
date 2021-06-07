package com.project.spring.service;

import java.util.List;

import com.project.spring.entity.Person;

public interface PersonService {
	
public List<Person> findAll();
	
	public void save(Person person);
	
	public Person findById(int personId);
	
	public void deleteById(int personId);
	
	public Person getPersonByFirstName(String firstName);
}
