package com.jits.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public abstract class Delivery {

	private Parcel parcel;
	private double zoneFactor;

	public Delivery(Parcel parcel, double zoneFactor) {
		this.setParcel(parcel);
		this.setZoneFactor(zoneFactor);
	}

	abstract double calculateDelivery();

	Map<String, Integer> getFirstDigitOfParcelZipcodes() {
		Map<String, Integer> firstDigits = new HashMap<String, Integer>();

		firstDigits.put("origin", Integer.parseInt(this.getParcel().getFrom().getZipcode().substring(0, 1)));
		firstDigits.put("dest", Integer.parseInt(this.getParcel().getTo().getZipcode().substring(0, 1)));

		return firstDigits;

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

	double getZoneFactor() {
		return zoneFactor;
	}

	private void setZoneFactor(double zoneFactor) {
		this.zoneFactor = zoneFactor;
	}

}
