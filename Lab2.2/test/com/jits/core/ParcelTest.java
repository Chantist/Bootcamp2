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
		letter = new Letter(Protection.FIRE_PROOF, 12345);
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
	public void testLetterProtection() {
		Protection expected = Protection.FIRE_PROOF;
		Protection actual = ((Letter) letter).getProtection();
		
		assertEquals(expected, actual);
	}

}
