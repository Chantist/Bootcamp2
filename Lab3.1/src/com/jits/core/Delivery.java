package com.jits.core;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public abstract class Delivery {

	private Parcel parcel;
	private int fromZone;
	private int toZone;

	public Delivery(Parcel parcel) {

		this.setParcel(parcel);
		this.setFromZone(this.getFirstDigitOfZipcodeAsInt(this.getParcel().getFrom().getZipcode()));
		this.setToZone(this.getFirstDigitOfZipcodeAsInt(this.getParcel().getTo().getZipcode()));
	}

	abstract double calculateDeliveryTime();

	private int getFirstDigitOfZipcodeAsInt(String zip) {
		return Integer.parseInt(zip.substring(0, 1));
	}

	public int review() {

		int response = JOptionPane.showConfirmDialog(null, this.toString(), "JITShipping", JOptionPane.YES_NO_OPTION);

		if (response == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, this.ship());
		} else {
			JOptionPane.showMessageDialog(null, this.cancel());
		}

		return response;
	}

	String ship() {

		return "Parcel has been shipped by " + this.getClass().getSimpleName().toLowerCase() + ".";
	}

	String cancel() {

		return "Delivery has been cancelled.";
	}

	@Override
	public String toString() {

		List<String> information = new ArrayList<String>();
		StringBuilder review = new StringBuilder();

		information.add(this.getClass().getSimpleName() + " " + this.getParcel().getClass().getSimpleName());
		information.add("Weight: " + this.getParcel().getWeight());
		information.add("Time until delivery: " + this.calculateDeliveryTime() + " days");
		information.add("From: " + this.getParcel().getFrom().toString());
		information.add("To: " + this.getParcel().getTo().toString());

		for (String info : information) {
			review.append(info);
			review.append("\n");
		}

		return review.toString();
	}

	public Parcel getParcel() {
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

}
