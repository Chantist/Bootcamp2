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
		box = new Box(5, 8, 10, 12345);
		letter = new Letter(12345);
	}
	
	@Test
	public void testNewBox() {
		int expected = 8;
		int actual = box.getHeight();
		assertEquals(expected, actual);
	}

	@Test
	public void testNewLetter() {
		long expected = 12345;
		long actual = letter.getId();
		assertEquals(expected, actual);
	}
	

	@Test
	public void testAddressesAreOnParcel() {
		assertFalse(letter.getFromAddress() == null);
		assertFalse(letter.getToAddress() == null);

		assertFalse(box.getFromAddress() == null);
		assertFalse(box.getToAddress() == null);

	}

	@Test
	public void testAddress() {
		assertEquals("Bucky Barnes | 123 Main St | Atlanta, GA 30326", letter.getFromAddress().toString());
		assertEquals("Luke Skywalker | 1111 Star Way | Dusty, CA 90008", letter.getToAddress().toString());

		assertEquals("Number One | 789 Onetwothree St | Atlanta, GA 11111", box.getFromAddress().toString());
		assertEquals("Dri Nowater | 89 Vacation Circle | Drought, ID 90008", box.getToAddress().toString());

	}

}
