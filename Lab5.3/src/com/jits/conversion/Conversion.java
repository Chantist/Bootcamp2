package com.jits.conversion;

public class Conversion {

	public double convertFromInchesToCubicFeet(double in) {
		double rtn = 1;
		
		if(in > 1) {
			rtn = in / (12 * 12 * 12);
		}

		return rtn;
	}

	public double convertFromOuncesToPounds(double ounces) {
		
		return ounces / 16;
	}
}
