package com.jits.core;

public class Air extends Delivery {

	public Air(Parcel parcel) {

		super(parcel);
	}

	@Override
	double calculateDeliveryTime() {

		double rtn = -1;

		if (super.getFromZone() == super.getToZone()) {
			rtn = .25;
		} else {
			rtn = super.calculateZoneDifference() * .25;
		}

		return rtn;
	}

}
