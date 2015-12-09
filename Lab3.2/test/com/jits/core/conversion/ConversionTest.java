package com.jits.core.conversion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConversionTest {
	Conversion convert;

	@Before
	public void setUp() throws Exception {
		convert = new Conversion();
	}

	@Test
	public void testConvertInchestoFeet() {

		assertEquals(5, convert.convertFromInchesToFeet(60), .001);
		assertEquals(3.0833333333333335, convert.convertFromInchesToFeet(37), .001);
		assertEquals(1.5, convert.convertFromInchesToFeet(18), .001);
		assertEquals(0.07333333333333333, convert.convertFromInchesToFeet(.88), .001);
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
