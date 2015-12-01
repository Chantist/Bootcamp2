package com.jits.core;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(AddressTest.class);
	
	private Address address;
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;

	@Before
	public void testAddress() {
		name = "Bob Smith";
		street	= "13 Oak Street"; 
		city =  "Anytown";
		state = "TN";
		zip = "37919";
		
		address = new Address(name, street, city, state, zip);
		assertThat(address.getName(), equalTo(name));
		assertThat(address.getStreet(), equalTo(street));
		assertThat(address.getCity(), equalTo(city));
		assertThat(address.getState(), equalTo(state));
		assertThat(address.getPostalCode(), equalTo(zip));
	
	}

	@Test
	public void testToString() {
		LOG.debug(address.toString());
		assertThat(address.toString(), Matchers.containsString("Name:"));
	}

}
