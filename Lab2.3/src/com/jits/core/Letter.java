package com.jits.core;

public class Letter extends Parcel implements Protectable {
	private Protection protection;

	public Letter(Address from, Address to, Protection protection, long id) {
		super(from, to, id);
		this.setProtection(protection);

	}

	Protection getProtection() {
		return protection;
	}

	private void setProtection(Protection protection) {
		this.protection = protection;
	}

	@Override
	public Protection protection() {
		return this.getProtection();
	}
}
