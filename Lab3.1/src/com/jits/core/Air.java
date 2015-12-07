package com.jits.core;

public class Air extends Delivery {

	public Air(Parcel parcel) {
		
		super(parcel);
	}

	@Override
	double calculateDeliveryTime() {

		double rtn = -1;
		int origin = super.getFromZone();
		int destination = super.getToZone();

		if (origin == destination) {
			rtn = .25;
		} else {
			rtn = Math.abs(destination - origin) * .25;
		}

		return rtn;
	}

}
