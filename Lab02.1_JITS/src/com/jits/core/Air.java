package com.jits.core;

class Air extends Delivery {
	// Delivery must have a Package (HAS-A)
	Air(Parcel pkg) {
		super(pkg);
	}

	String review() {
		return "Would you like to ship " + this.getParcel().getClass().getSimpleName() + " by air?";
	}

	String ship() {
		return "Shipped " + this.getParcel().getClass().getSimpleName() + " by air.";
	}

}