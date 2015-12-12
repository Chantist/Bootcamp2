package com.jits.conversion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jits.conversion.Conversion;

public class ConversionTest {
	Conversion convert;

	@Before
	public void setUp() throws Exception {
		convert = new Conversion();
	}

	@Test
	public void testConvertInchestoFeet() {

		assertEquals(0.03472222222, convert.convertFromInchesToCubicFeet(60), .001);
		assertEquals(0.02141203704, convert.convertFromInchesToCubicFeet(37), .001);
		assertEquals(0.01041666667, convert.convertFromInchesToCubicFeet(18), .001);
		assertEquals(1, convert.convertFromInchesToCubicFeet(.88), .001);
	}

	@Test
	public void testConvertOuncestoPounds() {

		assertEquals(2, convert.convertFromOuncesToPounds(32), .001);
		assertEquals(4, convert.convertFromOuncesToPounds(64), .001);
		assertEquals(0, convert.convertFromOuncesToPounds(0), .001);
		assertEquals(.0625, convert.convertFromOuncesToPounds(1), .001);
		assertEquals(2.3125, convert.convertFromOuncesToPounds(37), .001);
	}

}
