package com.jits.cost;

public class RailCost extends Cost {

	public RailCost(int zoneDifference) {
		super(zoneDifference);
	}

	@Override
	public double calculateCost() {
		double rtn = 0;

		if (this.getZoneDifference() == 0) {
			rtn = 2.75;
		} else if (this.getZoneDifference() == 1) {
			rtn = 5;
		}

		return rtn;
	}

}
