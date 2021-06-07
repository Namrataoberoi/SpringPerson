package com.project.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.spring.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	
	@Query("SELECT person FROM Person person WHERE person.firstName = :firstName")
	Person getPersonByFirstName(@Param("firstName") String firstName);

}
