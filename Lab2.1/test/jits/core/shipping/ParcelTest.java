package jits.core.shipping;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jits.core.shipping.Box;
import jits.core.shipping.Letter;
import jits.core.shipping.Parcel;

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

}
