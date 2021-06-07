package com.project.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.spring.entity.Address;
import com.project.spring.entity.Person;
import com.project.spring.exception.NotFoundException;
import com.project.spring.service.AddressService;
import com.project.spring.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonRestController {

	@Autowired
	PersonService personService;

	@Autowired
	AddressService addressService;

	public PersonRestController() {
	}

	@PostMapping("/persons")
	public void addPerson(@RequestBody Person person) {
		try {
			person.setId(0);
			if (person.getAddressList() != null && !person.getAddressList().isEmpty()) {
				for (Address add : person.getAddressList()) {
					add.setPerson(person);
					addressService.save(add);
				}
			}
			personService.save(person);
		} catch (Exception e) {
			throw e;
		}
	}

	@PutMapping("/persons")
	public Person updatePerson(@RequestBody Person person) throws NotFoundException {
		Person savedPerson = personService.getPersonByFirstName(person.getFirstName());
		if (savedPerson != null) {
			person.setId(savedPerson.getId());
			person.setAddressList(savedPerson.getAddressList());
			personService.save(person);
		} else {
			throw new NotFoundException("Person not found. Please save it.");
		}

		return person;
	}

	@GetMapping("/persons/{personId}")
	public Person getPersonById(@PathVariable int personId) throws NotFoundException {
		Person person = personService.findById(personId);

		if (person == null) {
			throw new NotFoundException("Person id not found - " + personId);
		} else {
			List<Address> addressList = addressService.findAllByPerson(personId);
			person.setAddressList(addressList);
		}
		return person;
	}

	@DeleteMapping("/persons/{personId}")
	public void deletePerson(@PathVariable int personId) throws NotFoundException {
		Person person = personService.findById(personId);
		if (person == null) {
			throw new NotFoundException("Person id not found - " + personId);
		}
		personService.deleteById(personId);
	}

	@GetMapping("/persons")
	public List<Person> getPersonList() {
		return personService.findAll();
	}

	@GetMapping("/persons/count")
	public int getPersonCount() {
		return personService.findAll().size();
	}
}
