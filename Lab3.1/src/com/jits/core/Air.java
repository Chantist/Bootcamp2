package com.jits.core;

public class Air extends Delivery {

	public Air(Parcel parcel) {
		super(parcel, .25);
	}

	@Override
	double calculateDelivery() {

		double rtn = 0;
		int origin = this.getFirstDigitOfParcelZipcodes().get("origin");
		int destination = this.getFirstDigitOfParcelZipcodes().get("origin");

		if (origin == destination) {
			rtn = .25;
		} else {
			rtn = Math.abs(destination - origin) * this.getZoneFactor();
		}

		return rtn;
	}

}
