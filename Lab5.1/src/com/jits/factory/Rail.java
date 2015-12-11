package com.jits.factory;

import java.util.NavigableMap;
import java.util.TreeMap;

import com.jits.core.Delivery;
import com.jits.core.Parcel;

public class Rail extends Delivery {
	private int origin;
	private int dest;
	private static NavigableMap<Integer, Integer> zones = new TreeMap<Integer, Integer>();

	public Rail(Parcel parcel) {
		super(parcel);
		this.setOrigin(Rail.zones.get(zones.floorKey(super.getFromZone())));
		this.setDest(Rail.zones.get(zones.floorKey(super.getToZone())));
	}

	static {
		zones.put(0, 1);
		zones.put(5, 2);
	}

	@Override
	public int calculateZoneDifference() {

		return Math.abs(this.getDest() - this.getOrigin());
	}

	@Override
	public double calculateDeliveryTime() {
		double rtn;
		
		if (this.getOrigin() == this.getDest()) {
			rtn = 5;
		} else {
			rtn = 10;
		}

		return rtn;
	}

	private int getOrigin() {
		return origin;
	}

	private void setOrigin(int origin) {
		this.origin = origin;
	}

	private int getDest() {
		return dest;
	}

	private void setDest(int dest) {
		this.dest = dest;
	}

}
