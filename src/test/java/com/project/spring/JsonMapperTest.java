package com.project.spring;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.spring.entity.Address;
import com.project.spring.entity.Person;

@SpringBootTest
public class JsonMapperTest {
	
	private Person getPerson() {
		Address address = new Address();
		address.setCity("South Dublin");
		address.setPostalCode("D24");
		address.setState("Dublin");
		address.setStreet("Belgard Square Road");
		
		Person person = new Person();
		person.setFirstName("John");
		person.setLastName("Grey");
		person.addAdress(address);
		
		return person;
	}

	@Test
	public void jsonMapperTest() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Person actual = mapper.readValue(new File("src//test//java//com//project//spring//sampleFile.json"), Person.class);
		
		Person expected = getPerson();
		
		Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
		Assert.assertEquals(expected.getLastName(), actual.getLastName());
		Assert.assertEquals(expected.getAddressList().get(0).getCity(), actual.getAddressList().get(0).getCity());
		Assert.assertEquals(expected.getAddressList().get(0).getPostalCode(), actual.getAddressList().get(0).getPostalCode());
		Assert.assertEquals(expected.getAddressList().get(0).getState(), actual.getAddressList().get(0).getState());
		Assert.assertEquals(expected.getAddressList().get(0).getStreet(), actual.getAddressList().get(0).getStreet());
		
	}

	
}
