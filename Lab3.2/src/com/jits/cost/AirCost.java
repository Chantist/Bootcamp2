package com.jits.cost;

public class AirCost extends Cost {
	
	private double volume;
	
	public AirCost(int zoneDifference, double weight, double volume) {

		super(zoneDifference, weight);
		
		this.setVolume(volume);
	}

	@Override
	public double calculateCost() {

		double cost = this.getZoneDifference() * this.getWeight() * this.getVolume() * 1.75;
		
		return super.roundToTwoDecimalPlaces(cost);
	}

	double getVolume() {
		
		return volume;
	}

	private void setVolume(double volume) {

		this.volume = this.getConverter().convertFromInchesToCubicFeet(volume);
	}

}
