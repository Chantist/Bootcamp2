package com.jits.shipping;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class ParcelTest {
	Parcel box;
	Parcel letter;
	
	@Before
	public void setUp() {
		box = new Box();
		letter = new Letter();
	}

	@Test
	public void testFamily() {
		assertTrue(box instanceof Box);
	}

}
