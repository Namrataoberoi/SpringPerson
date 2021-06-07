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
import com.project.spring.exception.NotFoundException;
import com.project.spring.service.AddressService;

@RestController
@RequestMapping("/api")
public class AddressRestController {

	@Autowired
	AddressService addressService;

	public AddressRestController() {
	}

	@PostMapping("/addresses")
	public void addAddress(@RequestBody Address address) {
		try {
			address.setId(0);
			addressService.save(address);
		} catch (Exception e) {
			throw e;
		}
	}

	@PutMapping("/addresses")
	public Address updateAddress(@RequestBody Address address) throws NotFoundException {
		Address savedAddress = addressService.findById(address.getId());
		if (savedAddress != null) {
			addressService.save(address);
		} else {
			throw new NotFoundException("Address not found. Please save it.");
		}
		return address;
	}

	@GetMapping("/addresses")
	public List<Address> getAddressList() {
		return addressService.findAll();
	}

	@GetMapping("/addresses/{addressId}")
	public Address getAddressById(@PathVariable int addressId) throws NotFoundException {
		Address address = addressService.findById(addressId);
		if (address == null) {
			throw new NotFoundException("Address id not found - " + addressId);
		}
		return address;
	}

	@DeleteMapping("/addresses/{addressId}")
	public void deleteAddressById(@PathVariable int addressId) throws NotFoundException {
		Address address = addressService.findById(addressId);
		if (address == null) {
			throw new NotFoundException("Address id not found - " + addressId);
		}
		addressService.deleteById(addressId);
	}

}
