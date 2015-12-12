package com.jits.transfer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.jits.core.Address;

public class ConfirmationBean implements IConfirmation, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8914806315192052809L;
	private String status;
	private Address origin;
	private Address dest;
	private String packageType;
	private String deliveryType;
	private double weight;
	private double deliveryTime;
	private double cost;
	private boolean insurance;
	private List<String> review = new ArrayList<String>();
	
	public ConfirmationBean() {
		
	}

	public ConfirmationBean(String status, Address origin, Address dest, String packageType, String deliveryType,
			double weight, double deliveryTime, double cost, boolean insurance) {

		this.setStatus(status);
		this.setOrigin(origin);
		this.setDest(dest);
		this.setPackageType(packageType);
		this.setDeliveryType(deliveryType);
		this.setWeight(weight);
		this.setDeliveryTime(deliveryTime);
		this.setCost(cost);
		this.setInsurance(insurance);
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
		return this.insurance;
	}

	@Override
	public double getDeliveryTime() {
		return this.deliveryTime;
	}

	@Override
	public double getCost() {
		return this.cost;
	}

	public List<String> getReview() {
		return review;
	}

	public void setReview(List<String> review) {
		this.review = review;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setOrigin(Address origin) {
		this.origin = origin;
	}

	public void setDest(Address dest) {
		this.dest = dest;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setDeliveryTime(double deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}

}
