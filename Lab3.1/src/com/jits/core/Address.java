package com.jits.core;

public class Address {

	private String name;
	private String street;
	private String state;
	private String city;
	private String zipcode;

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

	String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	String getStreet() {
		return street;
	}

	private void setStreet(String street) {
		this.street = street;
	}

	String getState() {
		return state;
	}

	private void setState(String state) {
		this.state = state;
	}

	String getCity() {
		return city;
	}

	private void setCity(String city) {
		this.city = city;
	}

	String getZipcode() {
		return zipcode;
	}

	private void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
