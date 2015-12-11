package com.jits.conversion;

public class Conversion {

	public double convertFromInchesToCubicFeet(double in) {

		return in / (12 * 12 * 12);
	}

	public double convertFromOuncesToPounds(double ounces) {
		
		return ounces / 16;
	}
}
