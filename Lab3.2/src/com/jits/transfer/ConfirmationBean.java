package com.jits.transfer;

import java.util.ArrayList;
import java.util.List;

import com.jits.core.Address;

public class ConfirmationBean implements IConfirmation {
	private String status;
	private Address origin;
	private Address dest;
	private String packageType;
	private String deliveryType;
	private double weight;
	private double deliveryTime;
	private double cost;
	private List<String> review = new ArrayList<String>();

	public ConfirmationBean(String status, Address origin, Address dest, String packageType, String deliveryType,
			double weight, double deliveryTime, double cost) {

		this.status = status;
		this.origin = origin;
		this.dest = dest;
		this.packageType = packageType;
		this.deliveryType = deliveryType;
		this.weight = weight;
		this.deliveryTime = deliveryTime;
		this.cost = cost;

		this.populateReviewList();
	}

	private void populateReviewList() {

		review.add("Status: " + this.getStatus());
		review.add("Origin: " + this.getOrigin().toString());
		review.add("Destination: " + this.getDest().toString());
		review.add("Delivery type: " + this.getDeliveryType());
		review.add("Package type: " + this.getPackageType());
		review.add("Weight: " + this.getWeight());
		review.add("Time: " + this.getDeliveryTime());
		review.add("Cost: " + this.getCost());
	}

	@Override
	public String toString() {

		StringBuilder rtn = new StringBuilder();

		for (String string : review) {
			rtn.append(string);
			rtn.append("\n");
		}

		return rtn.toString();

	}

	@Override
	public String getStatus() {
		return this.status;
	}

	@Override
	public Address getOrigin() {
		return this.origin;
	}

	@Override
	public Address getDest() {
		return this.dest;
	}

	@Override
	public String getPackageType() {
		return this.packageType;
	}

	@Override
	public String getDeliveryType() {
		return this.deliveryType;
	}

	@Override
	public double getWeight() {
		return this.weight;
	}

	@Override
	public boolean isInsured() {
		return false;
	}

	@Override
	public double getDeliveryTime() {
		return this.deliveryTime;
	}

	@Override
	public double getCost() {
		return this.cost;
	}

}
