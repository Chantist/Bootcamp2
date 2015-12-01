package com.jits.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DeliveryTest {
	private Address origin;
	private Address dest;

	@Before
	public void setUp() {
		origin = new Address("William Linux", "12 First Street", "El Paso",
				"TX", "12345");
		dest = new Address("Linus Windowman", "34 Second Street",
				"Kansas City", "MO", "34567");
	}

	@Test
	public void testPackageAir() {
		Parcel p1 = new Parcel(origin, dest, 1);
		Delivery d1 = new Air(p1);
		assertEquals("Would you like to ship Parcel by air?", d1.review());
		assertEquals("Shipped Parcel by air.", d1.ship());
		assertEquals("Delivery cancelled.", d1.cancel());
	}

	@Test
	public void testBoxGround() {
		Parcel p1 = new Box(origin, dest, 2, 8, 22, 4);
		Delivery d2 = new Ground(p1);
		assertEquals("Would you like to ship Box by ground?", d2.review());
		assertEquals("Shipped Box by ground.", d2.ship());
		assertEquals("Delivery cancelled.", d2.cancel());
	}
}