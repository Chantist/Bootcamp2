package com.jits.core;

class Address {
	private String name;
	private String street;
	private String city;
	private String state;
	private String postalCode;

	Address(String name, String street, String city, String state,
			String postalCode) {
		this.setName(name);
		this.setStreet(street);
		this.setCity(city);
		this.setState(state);
		this.setPostalCode(postalCode);
	}

	String getStreet() {
		return street;
	}

	void setStreet(String street) {
		this.street = street;
	}

	String getCity() {
		return city;
	}

	void setCity(String city) {
		this.city = city;
	}

	String getPostalCode() {
		return postalCode;
	}

	void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	String getState() {
		return state;
	}

	void setState(String state) {
		this.state = state;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	public String toString() {
		StringBuffer addressInfo = new StringBuffer(100);
		addressInfo.append("\n  Name: " + this.getName() + "\n  Street: "
				+ this.getStreet() + "\n  City: " + this.getCity()
				+ "\n  State: " + this.getState() + "\n  Postal Code: "
				+ this.getPostalCode());

		return addressInfo.toString();
	}
}