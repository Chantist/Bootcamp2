package com.jits.transfer;

import com.jits.core.Address;

public class Confirmation {
	private String status;
	private Address origin;
	private Address dest;
	private String packageType;
	private String deliveryType;
	private double weight;
	private double deliveryTime;
	private double cost;

	public Confirmation() {
	}

	public Confirmation(String status, Address origin, Address dest, String packageType, String deliveryType,
			double weight, double deliveryTime, double cost) {
		this.status = status;
		this.origin = origin;
		this.dest = dest;
		this.packageType = packageType;
		this.deliveryType = deliveryType;
		this.weight = weight;
		this.deliveryTime = deliveryTime;
		this.cost = cost;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Address getOrigin() {
		return this.origin;
	}

	public void setOrigin(Address origin) {
		this.origin = origin;
	}

	public Address getDest() {
		return this.dest;
	}

	public void setDest(Address dest) {
		this.dest = dest;
	}

	public String getPackageType() {
		return this.packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public String getDeliveryType() {
		return this.deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getDeliveryTime() {
		return this.deliveryTime;
	}

	public void setDeliveryTime(double deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer(512);
		buffer.append("\nStatus: " + this.getStatus());
		buffer.append("\nOrigin: " + this.getOrigin());
		buffer.append("\nDestination: " + this.getDest());
		buffer.append("\nPackage Type: " + this.getPackageType());
		buffer.append("\nDelivery Type: " + this.getDeliveryType());
		buffer.append("\nWeight: " + this.getWeight());
		buffer.append("\nDelivery Time: " + this.getDeliveryTime());
		buffer.append("\nCost: " + this.getCost());
		return buffer.toString();
	}
}