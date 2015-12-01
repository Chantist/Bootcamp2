package com.jits.core;

abstract class Parcel {
	
	private long id;
	private Address from;
	private Address to;

	Parcel(Address from, Address to, long id) {
		this.setId(id);
		this.setFrom(from);
		this.setTo(to);
	}

	private void setId(long id) {
		this.id = id;
	}

	long getId() {
		return this.id;
	}

	Address getFrom() {
		return from;
	}

	private void setFrom(Address from) {
		this.from = from;
	}

	Address getTo() {
		return to;
	}

	private void setTo(Address to) {
		this.to = to;
	}

}
