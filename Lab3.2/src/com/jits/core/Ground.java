package com.jits.core;

import java.util.NavigableMap;
import java.util.TreeMap;

import com.jits.core.cost.GroundCost;

public class Ground extends Delivery {
	private static NavigableMap<Integer, Integer> zones = new TreeMap<Integer, Integer>();

	public Ground(Parcel parcel) {

		super(parcel);

	}

	static {

		zones.put(0, 1);
		zones.put(3, 2);
		zones.put(6, 3);
		zones.put(8, 4);
	}

	@Override
	double calculateDeliveryTime() {

		double time = -1;

		int origin = Ground.zones.get(zones.floorKey(super.getFromZone()));
		int dest = Ground.zones.get(zones.floorKey(super.getToZone()));

		if (super.calculateZoneDifference(dest, origin) == 0) {
			time = 1;
		} else {
			time = super.calculateZoneDifference(origin, dest) * 1.5;
		}

		return time;
	}

	@Override
	double determineCost() {

		int origin = Ground.zones.get(zones.floorKey(super.getFromZone()));
		int dest = Ground.zones.get(zones.floorKey(super.getToZone()));

		double rtn = new GroundCost(super.calculateZoneDifference(origin, dest), this.getParcel().getWeight(),
				super.getToZone(), super.getFromZone()).calculateCost();

		return rtn;
	}

}
