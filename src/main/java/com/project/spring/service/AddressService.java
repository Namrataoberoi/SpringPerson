package com.project.spring.service;

import java.util.List;

import com.project.spring.entity.Address;

public interface AddressService {
	
	public void save(Address address);
	
	public Address findById(int addressId);
	
	public void deleteById(int addressId);

	public List<Address> findAll();
	
	public List<Address> findAllByPerson(int personId);

}
