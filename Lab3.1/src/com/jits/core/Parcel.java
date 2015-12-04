package com.jits.core;

import com.thirdParty.calibration.MailScale;

public abstract class Parcel {

	private long id;
	private Address from;
	private Address to;
	private double weight;

	public Parcel(Address from, Address to, long id) {
		
		this.setId(id);
		this.setFrom(from);
		this.setTo(to);
		this.setWeight(this.weighParcel());
	}

	double weighParcel() {

		return Math.ceil(new MailScale().calculateWeight(this));
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

	public double getWeight() {
		return weight;
	}

	private void setWeight(double weight) {
		this.weight = weight;
	}

}
