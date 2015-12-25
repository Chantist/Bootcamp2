package com.jits.core;

import java.io.Serializable;

public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1406577509278268553L;
	private String name;
	private String street;
	private String state;
	private String city;
	private String zipcode;
	
	public Address() {
		
	}

	public Address(String name, String street, String state, String city, String zipcode) {

		this.setName(name);
		this.setStreet(street);
		this.setState(state);
		this.setCity(city);
		this.setZipcode(zipcode);
	}

	@Override
	public String toString() {

		return this.getName() + " | " + this.getStreet() + " | " + this.getCity() + ", " + this.getState() + " "
				+ this.getZipcode();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
