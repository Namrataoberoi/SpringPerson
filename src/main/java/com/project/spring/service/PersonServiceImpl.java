package com.project.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.spring.entity.Person;
import com.project.spring.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;
	
	public PersonServiceImpl(PersonRepository personRepositoryParam) {
		personRepository = personRepositoryParam;
	}

	@Override
	public void save(Person person) {
		personRepository.save(person);
	}	
	
	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	public Person findById(int personId) {
		Optional<Person> result = personRepository.findById(personId);
		Person person = null;
		if (result.isPresent()) {
			person = result.get();
		}
		return person;
	}

	@Override
	public void deleteById(int personId) {
		personRepository.deleteById(personId);
	}

	@Override
	public Person getPersonByFirstName(String firstName) {
		return personRepository.getPersonByFirstName(firstName);
	}

}
