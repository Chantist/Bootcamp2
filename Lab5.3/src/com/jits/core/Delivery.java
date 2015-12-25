package com.jits.core;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.jits.cost.Cost;
import com.jits.transfer.ConfirmationBean;
import com.jits.transfer.IConfirmation;

public abstract class Delivery {

	private Parcel parcel;
	private int fromZone;
	private int toZone;
	private Cost calculator;
	private double cost;
	private String status;

	Delivery(Parcel parcel) {

		this.setParcel(parcel);
		this.setFromZone();
		this.setToZone();
		this.getParcel().weighParcel();
		this.setStatus("Pending");
	}

	public abstract double calculateDeliveryTime();

	public double calculateCost() {
		double rtn = this.getCalculator().calculateCost();

		this.setCost(rtn);

		return rtn;
	}

	private int getFirstDigitOfZipcodeAsInt(String zip) {

		return Integer.parseInt(zip.substring(0, 1));
	}

	public void log(IConfirmation bean) {

		try (XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Storage.xml")))) {
			e.writeObject(bean);

		} catch (FileNotFoundException exp) {
			exp.printStackTrace();
		}

	}

	int calculateZoneDifference() {

		int rtn = Math.abs(this.getToZone() - this.getFromZone());

		if (rtn == 0) {
			rtn = 1;
		}

		return rtn;
	}

	private IConfirmation createConfirmation(String status) {
		IConfirmation rtn = null;

		if (this.getParcel() instanceof Insurable) {
			rtn = new ConfirmationBean(status, this.getParcel().getFrom(), this.getParcel().getTo(),
					this.getParcel().getClass().getSimpleName(), this.getClass().getSimpleName(),
					this.getParcel().getWeight(), this.calculateDeliveryTime(), this.calculateCost(),
					((Insurable) this.getParcel()).getInsurance());
		} else {
			rtn = new ConfirmationBean(status, this.getParcel().getFrom(), this.getParcel().getTo(),
					this.getParcel().getClass().getSimpleName(), this.getClass().getSimpleName(),
					this.getParcel().getWeight(), this.calculateDeliveryTime(), this.calculateCost(), false);
		}

		return rtn;
	}

	public IConfirmation review() {
		this.setStatus("Pending");
		return this.createConfirmation("Pending");
	}

	public IConfirmation ship() {
		this.setStatus("Delivered");
		return this.createConfirmation("Delivered");
	}

	public IConfirmation cancel() {
		this.setStatus("Cancelled");
		return this.createConfirmation("Cancelled");
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

	Parcel getParcel() {
		return parcel;
	}

	private void setParcel(Parcel parcel) {
		this.parcel = parcel;
	}

	int getToZone() {
		return toZone;
	}

	private void setToZone() {
		this.toZone = this.getFirstDigitOfZipcodeAsInt(this.getParcel().getTo().getZipcode());
	}

	int getFromZone() {
		return fromZone;
	}

	private void setFromZone() {
		this.fromZone = this.getFirstDigitOfZipcodeAsInt(this.getParcel().getFrom().getZipcode());
	}

	private Cost getCalculator() {
		return calculator;
	}

	void setCalculator(Cost calculator) {
		this.calculator = calculator;
	}

	String getStatus() {
		return status;
	}

	private void setStatus(String status) {
		this.status = status;
	}

	double getCost() {
		return cost;
	}

	private void setCost(double cost) {
		this.cost = cost;
	}

}
