package com.jits.core;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.jits.cost.Cost;
import com.jits.transfer.ConfirmationBean;

public abstract class Delivery {

	private Parcel parcel;
	private int fromZone;
	private int toZone;
	private Cost cost;
	private String status;

	public Delivery(Parcel parcel) {

		this.setParcel(parcel);
		this.setFromZone(this.getFirstDigitOfZipcodeAsInt(this.getParcel().getFrom().getZipcode()));
		this.setToZone(this.getFirstDigitOfZipcodeAsInt(this.getParcel().getTo().getZipcode()));
		this.getParcel().weighParcel();
		this.setStatus("Pending");
	}

	public abstract double calculateDeliveryTime();

	private double determineCost() {

		return this.getCost().calculateCost();
	}

	public int calculateZoneDifference() {

		int rtn = Math.abs(this.getToZone() - this.getFromZone());

		if (rtn == 0) {
			rtn = 1;
		}

		return rtn;
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

	public ConfirmationBean review() {
		ConfirmationBean rtn = new ConfirmationBean(this.getStatus(), this.getParcel().getFrom(), this.getParcel().getTo(),
				this.getParcel().getClass().getSimpleName(), this.getClass().getSimpleName(),
				this.getParcel().getWeight(), this.calculateDeliveryTime(), this.cost());
		
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

	public Parcel getParcel() {
		return parcel;
	}

	private void setParcel(Parcel parcel) {
		this.parcel = parcel;
	}

	public int getToZone() {
		return toZone;
	}

	private void setToZone(int toZone) {
		this.toZone = toZone;
	}

	public int getFromZone() {
		return fromZone;
	}

	private void setFromZone(int fromZone) {
		this.fromZone = fromZone;
	}

	Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}

	String getStatus() {
		return status;
	}

	private void setStatus(String status) {
		this.status = status;
	}

}
