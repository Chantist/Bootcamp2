package com.jits.cost;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.jits.conversion.Conversion;

public abstract class Cost {
	private int zoneDifference;
	private double weight = -1;
	private Conversion converter = new Conversion();

	Cost(int zoneDifference, double weight) {

		this.setZoneDifference(zoneDifference);

		this.setWeight(weight);
	}

	public abstract double calculateCost();

	double roundToTwoDecimalPlaces(double number) {

		NumberFormat formatter = new DecimalFormat("#0.00");
		formatter.setRoundingMode(RoundingMode.DOWN);

		return Double.parseDouble(formatter.format(number));
	}

	Conversion getConverter() {
		return converter;
	}

	int getZoneDifference() {
		return zoneDifference;
	}

	private void setZoneDifference(int zoneDifference) {
		this.zoneDifference = zoneDifference;
	}

	public double getWeight() {
		return weight;
	}

	private void setWeight(double weight) {
		this.weight = this.getConverter().convertFromOuncesToPounds(weight);
	}

}
