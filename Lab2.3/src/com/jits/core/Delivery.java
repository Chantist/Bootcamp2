package com.jits.core;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public abstract class Delivery {

	private Parcel parcel;

	public Delivery(Parcel parcel, Parcel... parcels) {
		this.setParcel(parcel);
	}

	int review() {
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

}
