package com.project.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.spring.entity.Address;
import com.project.spring.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	public AddressServiceImpl(AddressRepository addressRepositoryParam) {
		addressRepository = addressRepositoryParam;
	}

	@Override
	public void save(Address address) {
		addressRepository.save(address);

	}
	
	@Override
	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	@Override
	public Address findById(int addressId) {
		Optional<Address> result = addressRepository.findById(addressId);
		Address address = null;
		if (result.isPresent()) {
			address = result.get();
		}
		return address;
	}

	@Override
	public void deleteById(int addressId) {
		addressRepository.deleteById(addressId);
	}
	
	@Override
	public List<Address> findAllByPerson(int personId){
		return addressRepository.getAddressListByPerson(personId);
	}

}
