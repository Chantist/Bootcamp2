package com.jits.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class DeliveryTest {

	private Delivery grd;
	private Delivery air;
	private Parcel letter;
	private Parcel box;

	@Before
	public void setUp() {
		box = new Box(7, 5, 6, 8934679867L);
		letter = new Letter(974434120L);

		grd = new Ground(box, new Address("Bucky Barnes", "123 Main St", "GA", "Atlanta", "30326"),
				new Address("Luke Skywalker", "1111 Star Way", "CA", "Dusty", "90008"));
		air = new Air(letter, new Address("Number One", "789 Onetwothree St", "GA", "Atlanta", "11111"),
				new Address("Dri Nowater", "89 Vacation Circle", "ID", "Drought", "90008"));

	}

	@Test
	public void testParcelIsOnDelivery() {
		assertFalse(grd.getParcel() == null);
		assertFalse(air.getParcel() == null);

	}

	@Test
	public void testGetData() {
		String expected = "Ground Box (Dimensions: 7, 5, 6)" + "\n"
				+ "From: Bucky Barnes | 123 Main St | Atlanta, GA 30326" + "\n"
				+ "To: Luke Skywalker | 1111 Star Way | Dusty, CA 90008" + "\n";
		String actual = grd.getData();

		assertEquals(expected, actual);

	}

}
