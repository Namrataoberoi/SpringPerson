package com.project.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.spring.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	@Query("SELECT address FROM Address address WHERE address.person.id = :id")
	List<Address> getAddressListByPerson(@Param("id") int id);

}
