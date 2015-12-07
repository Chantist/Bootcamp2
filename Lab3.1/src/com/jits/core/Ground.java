package com.jits.core;

import java.util.NavigableMap;
import java.util.TreeMap;

public class Ground extends Delivery {

	public Ground(Parcel parcel) {

		super(parcel);
	}

	@Override
	double calculateDeliveryTime() {

		double time = -1;
		int zoneDifference = this.determineZoneDifference();

		if (zoneDifference == 0) {
			time = 1;
		} else {
			time = zoneDifference * 1.5;
		}

		return time;
	}

	private int determineZoneDifference() {

		NavigableMap<Integer, Integer> zones = new TreeMap<Integer, Integer>();
		zones.put(0, 1);
		zones.put(3, 2);
		zones.put(6, 3);
		zones.put(8, 4);

		int start = zones.get(zones.floorKey(super.getFromZone()));
		int end = zones.get(zones.floorKey(super.getToZone()));

		return Math.abs(end - start);
	}

}
