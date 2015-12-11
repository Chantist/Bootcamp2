package com.jits.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParcelTest {

	private Parcel box;
	private Parcel letter;

	@Before
	public void setUp() {

		box = new Box(new Address("Bucky Barnes", "123 Main St", "GA", "Atlanta", "30326"),
				new Address("Luke Skywalker", "1111 Star Way", "CA", "Dusty", "90008"), 5, 8, 10, 12345, true);
		letter = new Letter(new Address("Number One", "789 Onetwothree St", "GA", "Atlanta", "11111"),
				new Address("Dri Nowater", "89 Vacation Circle", "ID", "Drought", "90008"), Protection.FIRE_PROOF,
				12345);
	}

	@Test
	public void testNewBox() {
		
		assertEquals(true, box.getInsurance());
		assertEquals(5, ((Dimensionable) box).height());
		assertEquals(8, ((Dimensionable) box).width());
		assertEquals(10, ((Dimensionable) box).depth());
	}

	@Test
	public void testNewLetter() {

		long expected = 12345;
		long actual = letter.getId();
		assertEquals(expected, actual);
		assertEquals(false, letter.getInsurance());
	}

	@Test
	public void testLetterProtection() {

		Protection expected = Protection.FIRE_PROOF;
		Protection actual = ((Protectable) letter).protection();

		assertEquals(expected, actual);
	}

	@Test
	public void testAddressesAreOnDelivery() {

		assertFalse(box.getFrom() == null);
		assertFalse(box.getTo() == null);

		assertFalse(letter.getFrom() == null);
		assertFalse(letter.getTo() == null);

	}

	@Test
	public void testAddress() {

		assertEquals("Bucky Barnes | 123 Main St | Atlanta, GA 30326", box.getFrom().toString());
		assertEquals("Luke Skywalker | 1111 Star Way | Dusty, CA 90008", box.getTo().toString());

		assertEquals("Number One | 789 Onetwothree St | Atlanta, GA 11111", letter.getFrom().toString());
		assertEquals("Dri Nowater | 89 Vacation Circle | Drought, ID 90008", letter.getTo().toString());

	}

	@Test
	public void testWeighParcel() {

		assertEquals(box.weighParcel(), box.getWeight(), .001);
		assertEquals(letter.weighParcel(), letter.getWeight(), .001);

		assertEquals(0, letter.weighParcel(), .001);
		assertEquals(0, box.weighParcel(), .001);
	}

	@Test
	public void testParcelVolume() {

		assertEquals(1, letter.volume(), .001);
		assertEquals(400, box.volume(), .001);
	}
}
