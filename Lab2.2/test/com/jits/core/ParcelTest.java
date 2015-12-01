package com.jits.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jits.core.Box;
import com.jits.core.Letter;
import com.jits.core.Parcel;

public class ParcelTest {

	private Parcel box;
	private Parcel letter;

	@Before
	public void setUp() {
		box = new Box(new Address("Bucky Barnes", "123 Main St", "GA", "Atlanta", "30326"),
				new Address("Luke Skywalker", "1111 Star Way", "CA", "Dusty", "90008"), 5, 8, 10, 12345);
		letter = new Letter(new Address("Number One", "789 Onetwothree St", "GA", "Atlanta", "11111"),
				new Address("Dri Nowater", "89 Vacation Circle", "ID", "Drought", "90008"), Protection.FIRE_PROOF,
				12345);
	}

	@Test
	public void testNewBox() {
		assertEquals(5, ((Dimensionable) box).height());
		assertEquals(8, ((Dimensionable) box).width());
		assertEquals(10, ((Dimensionable) box).depth());
	}

	@Test
	public void testNewLetter() {
		long expected = 12345;
		long actual = letter.getId();
		assertEquals(expected, actual);
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

}
