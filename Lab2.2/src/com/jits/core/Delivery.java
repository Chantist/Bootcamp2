package com.jits.core;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

abstract class Delivery {

	private Address fromAddress;
	private Address toAddress;
	private Parcel parcel;

	Delivery(Parcel parcel, Address fromAddress, Address toAddress) {
		this.setParcel(parcel);
		this.setFromAddress(fromAddress);
		this.setToAddress(toAddress);
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
		information.add("From: " + this.getFromAddress().toString());
		information.add("To: " + this.getToAddress().toString());

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

	Address getToAddress() {
		return toAddress;
	}

	private void setToAddress(Address toAddress) {
		this.toAddress = toAddress;
	}

	Address getFromAddress() {
		return fromAddress;
	}

	private void setFromAddress(Address fromAddress) {
		this.fromAddress = fromAddress;
	}

}
