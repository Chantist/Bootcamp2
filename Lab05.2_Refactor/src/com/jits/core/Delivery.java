package com.jits.core;

import com.jits.pricing.CostCalculator;
import com.jits.transfer.Confirmation;

public abstract class Delivery {
	// Delivery has field ref to its Package (HAS-A)
	private Package pkg;
	// will be set by factory ("injected")
	private CostCalculator costCalc;
	// computed values
	private double deliveryTime = -1; // indicates not computed yet
	private double shippingCost = -1; // indicates not computed yet

	// Delivery must have a Package (HAS-A)
	Delivery(Package pkg) {
		this.setPackage(pkg);
	}

	// defer implementation to subclasses
	public abstract double calculateDeliveryTime();

	// delegates to cost calculator (JITS internal mail uses it also)
	public double calculateShippingCost() {
		this.setShippingCost(this.getCostCalculator().calculateCost());
		return this.getShippingCost();
	}

	// these return a Confirmation object with the appropriate status
	public Confirmation review() {
		return this.createConfirmation("Pending");
	}

	public Confirmation ship() {
		return this.createConfirmation("Delivered");
	}

	public Confirmation cancel() {
		return this.createConfirmation("Cancelled");
	}

	double getDeliveryTime() {
		return deliveryTime;
	}

	void setDeliveryTime(double deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	double getShippingCost() {
		return shippingCost;
	}

	private void setShippingCost(double cost) {
		this.shippingCost = cost;
	}

	Package getPackage() {
		return this.pkg;
	}

	void setPackage(Package pkg) {
		this.pkg = pkg;
	}

	CostCalculator getCostCalculator() {
		return this.costCalc;
	}

	void setCostCalculator(CostCalculator costCalc) {
		this.costCalc = costCalc;
	}

	private Confirmation createConfirmation(String status) {
		return new Confirmation(status, this.getPackage().getOrigin(), this.getPackage().getDestination(),
				this.getPackage().getClass().getName(), this.getClass().getName(), this.getPackage().getWeight(),
				this.getDeliveryTime(), this.getShippingCost());
	}
}