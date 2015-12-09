package com.jits.core;

import com.jits.core.cost.AirCost;

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
			rtn = super.calculateZoneDifference(super.getFromZone(), super.getToZone()) * .25;
		}

		return rtn;
	}

	@Override
	double determineCost() {
		
		double rtn = new AirCost(super.calculateZoneDifference(super.getFromZone(), super.getToZone()),
				this.getParcel().getWeight(), this.getParcel().volume()).calculateCost();
		
		return rtn;
	}

}
