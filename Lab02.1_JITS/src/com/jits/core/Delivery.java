package com.jits.core;

abstract class Delivery {
	// Delivery has field ref to its Package (HAS-A)
	private Parcel pkg;

	// Delivery must have a Package (HAS-A)
	Delivery(Parcel pkg) {
		this.setPackage(pkg);
	}

	abstract String review();

	abstract String ship();

	String cancel() {
		return "Delivery cancelled.";
	}

	Parcel getParcel() {
		return this.pkg;
	}

	void setPackage(Parcel pkg) {
		this.pkg = pkg;
	}
}