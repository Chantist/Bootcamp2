package com.jits.core.cost;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.jits.core.conversion.Conversion;

abstract class Cost {
	private int zoneDifference;
	private double weight;
	private Conversion converter = new Conversion();

	Cost(int zoneDifference, double weight) {

		this.setZoneDifference(zoneDifference);

		if (weight >= 1) {
			this.setWeight(this.getConverter().convertFromOuncesToPounds(weight));
		} else {
			this.setWeight(1);
		}

	}

	abstract double calculateCost();
	
	double roundToTwoDecimalPlaces(double number) {
		
		NumberFormat formatter = new DecimalFormat("#0.00");
		formatter.setRoundingMode(RoundingMode.FLOOR);
		
		return Double.parseDouble(formatter.format(number));
	}

	Conversion getConverter() {
		return converter;
	}

	void setConverter(Conversion converter) {
		this.converter = converter;
	}

	int getZoneDifference() {
		return zoneDifference;
	}

	private void setZoneDifference(int zoneDifference) {
		this.zoneDifference = zoneDifference;
	}

	double getWeight() {
		return weight;
	}

	private void setWeight(double weight) {
		this.weight = weight;
	}

}
