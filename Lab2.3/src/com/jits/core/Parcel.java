package com.jits.core;

public abstract class Parcel {
	
	private long id;
	private Address from;
	private Address to;

	public Parcel(Address from, Address to, long id) {
		this.setId(id);
		this.setFrom(from);
		this.setTo(to);
	}

	private void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
	}

	public Address getFrom() {
		return from;
	}

	private void setFrom(Address from) {
		this.from = from;
	}

	public Address getTo() {
		return to;
	}

	private void setTo(Address to) {
		this.to = to;
	}

}
