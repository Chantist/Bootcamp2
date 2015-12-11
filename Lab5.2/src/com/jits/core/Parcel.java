package com.jits.core;

abstract class Parcel {

	private long id;
	private Address from;
	private Address to;
	private double weight;

	public Parcel(Address from, Address to, long id) {

		this.setId(id);
		this.setFrom(from);
		this.setTo(to);
		this.setWeight(-1);
	}

	double weighParcel() {

		double rtn = 0;

		if (this.getWeight() <= 0) {
			rtn = ((Weighable) ScaleAdapter.getInstance()).weigh(this);
			this.setWeight(rtn);
		}

		return rtn;
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

	void setWeight(double weight) {
		this.weight = weight;
	}

	public double volume() {
		return 1.0;
	}
	
	public boolean getInsurance() {
		return false;
	}

}
