package com.jits.core;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.jits.cost.Cost;
import com.jits.transfer.ConfirmationBean;

abstract class Delivery {

	private Parcel parcel;
	private int fromZone;
	private int toZone;
	private Cost cost;
	private String status;

	Delivery(Parcel parcel) {

		this.setParcel(parcel);
		this.setFromZone(this.getFirstDigitOfZipcodeAsInt(this.getParcel().getFrom().getZipcode()));
		this.setToZone(this.getFirstDigitOfZipcodeAsInt(this.getParcel().getTo().getZipcode()));
		this.getParcel().weighParcel();
		this.setStatus("Pending");
	}

	protected abstract double calculateDeliveryTime();

	private double determineCost() {

		return this.getCost().calculateCost();
	}

	private int getFirstDigitOfZipcodeAsInt(String zip) {

		return Integer.parseInt(zip.substring(0, 1));
	}

	private void log(ConfirmationBean bean) {

		try (XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Storage.xml")))) {
			e.writeObject(bean);

		} catch (FileNotFoundException exp) {
			exp.printStackTrace();
		}

	}

	final String prepareDelivery() {
		List<String> strings = new ArrayList<String>();
		strings.add("Cost: " + this.determineCost());
		strings.add("Delivery time: " + this.calculateDeliveryTime());

		if (this.getParcel().getClass().getName() == "Box") {
			strings.add("Insured: " + this.getParcel().getInsurance());
		}

		StringBuilder builder = new StringBuilder();

		for (String string : strings) {
			builder.append(string);
			builder.append("\n");
		}

		return builder.toString();
	}

	int calculateZoneDifference() {

		int rtn = Math.abs(this.getToZone() - this.getFromZone());

		if (rtn == 0) {
			rtn = 1;
		}

		return rtn;
	}

	ConfirmationBean review() {
		ConfirmationBean rtn = new ConfirmationBean(this.getStatus(), this.getParcel().getFrom(),
				this.getParcel().getTo(), this.getParcel().getClass().getSimpleName(), this.getClass().getSimpleName(),
				this.getParcel().getWeight(), this.calculateDeliveryTime(), this.cost(),
				this.getParcel().getInsurance());

		this.log(rtn);

		return rtn;
	}

	String ship() {
		this.setStatus("Shipped");
		return "Parcel has been shipped by " + this.getClass().getSimpleName().toLowerCase() + ".";
	}

	String cancel() {
		this.setStatus("Cancelled");
		return "Delivery has been cancelled.";
	}

	@Override
	public String toString() {

		List<String> information = new ArrayList<String>();
		StringBuilder review = new StringBuilder();

		information.add(this.getClass().getSimpleName() + " " + this.getParcel().getClass().getSimpleName());
		information.add("Time until delivery: " + this.calculateDeliveryTime() + " days");
		information.add("From: " + this.getParcel().getFrom().toString());
		information.add("To: " + this.getParcel().getTo().toString());

		for (String info : information) {
			review.append(info);
			review.append("\n");
		}

		return review.toString();
	}

	double cost() {
		return this.determineCost();
	}

	Parcel getParcel() {
		return parcel;
	}

	private void setParcel(Parcel parcel) {
		this.parcel = parcel;
	}

	int getToZone() {
		return toZone;
	}

	private void setToZone(int toZone) {
		this.toZone = toZone;
	}

	int getFromZone() {
		return fromZone;
	}

	private void setFromZone(int fromZone) {
		this.fromZone = fromZone;
	}

	Cost getCost() {
		return cost;
	}

	void setCost(Cost cost) {
		this.cost = cost;
	}

	String getStatus() {
		return status;
	}

	private void setStatus(String status) {
		this.status = status;
	}

}
