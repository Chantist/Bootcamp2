package com.jits.core;

import java.util.NavigableMap;
import java.util.TreeMap;

public class Ground extends Delivery {

	public Ground(Parcel parcel) {
		super(parcel, 1.5);
	}

	private int determineZoneDifference() {
		NavigableMap<Integer, Integer> zones = new TreeMap<Integer, Integer>();
		zones.put(0, 1);
		zones.put(3, 2);
		zones.put(6, 3);
		zones.put(8, 4);

		int origin = zones.get(zones.floorKey(this.getFirstDigitOfParcelZipcodes().get("origin")));
		int dest = zones.get(zones.floorKey(this.getFirstDigitOfParcelZipcodes().get("dest")));

		return Math.abs(dest - origin);
	}

	@Override
	double calculateDelivery() {

		double time = -1;

		if (this.determineZoneDifference() == 0) {
			time = 1;
		} else {
			time = this.determineZoneDifference() * this.getZoneFactor();
		}

		return time;
	}

}
