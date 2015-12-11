package com.jits.cost;

public class GroundCost extends Cost {
	
	private int to;
	private int from;

	public GroundCost(int zoneDifference, double weight, int to, int from) {
		super(zoneDifference, weight);
		this.setFrom(from);
		this.setTo(to);

	}

	private double determineDiscount() {
		
		double rtn = 0;
		
		if ( !(this.getFrom() > 7 || this.getTo() > 7) ) {
			rtn = .05;
		}
		return rtn;
	}

	@Override
	public double calculateCost() {
		
		double cost = this.getZoneDifference() * this.getWeight() * 1.1;
		double discount = cost * this.determineDiscount();
		cost -= discount;

		return super.roundToTwoDecimalPlaces(cost);

	}

	int getTo() {
		return to;
	}

	void setTo(int to) {
		this.to = to;
	}

	int getFrom() {
		return from;
	}

	void setFrom(int from) {
		this.from = from;
	}

}
