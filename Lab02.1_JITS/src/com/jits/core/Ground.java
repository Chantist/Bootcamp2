package com.jits.core;

class Ground extends Delivery {
	// Delivery must have a Package (HAS-A)
	Ground(Parcel pkg) {
		super(pkg);
	}

	String review() { 
		return "Would you like to ship " + this.getParcel().getClass().getSimpleName() + " by ground?";
	}

	String ship() {
		return "Shipped " + this.getParcel().getClass().getSimpleName() + " by ground.";
	}

}