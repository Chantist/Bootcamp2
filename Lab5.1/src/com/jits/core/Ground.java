package com.jits.core;

import java.util.NavigableMap;
import java.util.TreeMap;

public class Ground extends Delivery {
	private static NavigableMap<Integer, Integer> zones = new TreeMap<Integer, Integer>();
	private int origin;
	private int dest;

	public Ground(Parcel parcel) {

		super(parcel);
		this.setOrigin(Ground.zones.get(zones.floorKey(super.getFromZone())));
		this.setDest(Ground.zones.get(zones.floorKey(super.getToZone())));

	}

	static {

		zones.put(0, 1);
		zones.put(3, 2);
		zones.put(6, 3);
		zones.put(8, 4);
	}
	
	@Override
	public int calculateZoneDifference() { 
		
		return Math.abs(this.getDest() - this.getOrigin());
	}

	@Override
	public double calculateDeliveryTime() {

		double time = -1;

		if (this.calculateZoneDifference() == 0) {
			time = 1;
		} else {
			time = this.calculateZoneDifference() * 1.5;
		}

		return time;
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
