package com.jits.core;

class Parcel {
	private Address origin;
	private Address destination;
	private long id;

	Parcel(Address origin, Address destination, long id) {
		this.setOrigin(origin);
		this.setDestination(destination);
		this.setId(id);
	}

	Address getOrigin() {
		return origin;
	}

	void setOrigin(Address origin) {
		this.origin = origin;
	}

	Address getDestination() {
		return destination;
	}

	void setDestination(Address destination) {
		this.destination = destination;
	}

	long getId() {
		return id;
	}

	void setId(long id) {
		this.id = id;
	}

	public String toString() {
		StringBuffer packageInfo = new StringBuffer(250);
		packageInfo.append("\nID: " + this.getId() + "\nOrigin: "
				+ this.getOrigin() + "\nDestination: " + this.getDestination());

		return packageInfo.toString();
	}
}