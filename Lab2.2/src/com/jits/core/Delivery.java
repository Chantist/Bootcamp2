package com.jits.core;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

abstract class Delivery {

	private Parcel parcel;

	Delivery(Parcel parcel, Parcel...parcels) {
		this.setParcel(parcel);
	}

	int review() {
		int response = JOptionPane.showConfirmDialog(null, this.getData(), "JITShipping", JOptionPane.YES_NO_OPTION);
		if (response == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Parcel has been shipped by " + this.getClass().getSimpleName() + ".");
		} else {
			JOptionPane.showMessageDialog(null, "Delivery cancelled.");
		}

		return response;
	}

	String getData() {
		List<String> information = new ArrayList<String>();

		information.add(this.getClass().getSimpleName() + " " + this.getParcel().getClass().getSimpleName() + " ("
				+ this.getParcel().getDimensions() + ")");
		information.add("From: " + this.getParcel().getFrom().toString());
		information.add("To: " + this.getParcel().getTo().toString());

		StringBuilder review = new StringBuilder();

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

}
