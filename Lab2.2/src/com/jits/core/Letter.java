package com.jits.core;

class Letter extends Parcel {
	private Protection protection;

	Letter(Address from, Address to, Protection protection, long id) {
		super(from, to, 0, 0, 0, id);
		this.setProtection(protection);
		
	}

	Protection getProtection() {
		return protection;
	}

	private void setProtection(Protection protection) {
		this.protection = protection;
	}
}
