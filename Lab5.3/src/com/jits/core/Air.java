package com.jits.core;

class Air extends Delivery {

	Air(Parcel parcel) {

		super(parcel);
	}

	@Override
	public double calculateDeliveryTime() {

		double rtn = -1;

		if (super.getFromZone() == super.getToZone()) {
			rtn = .25;
		} else {
			rtn = super.calculateZoneDifference() * .25;
		}

		return rtn;
	}

}
