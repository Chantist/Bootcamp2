package com.jits.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.jits.factory.DeliveryFactory;

public class DeliveryTest {

	private Delivery grd;
	private Delivery air;
	private Map<String, String> grdMap = new HashMap<String, String>();
	private Map<String, String> airMap = new HashMap<String, String>();

	@Before
	public void setUp() {
		
		grdMap.put("type", "BG");
		grdMap.put("id", "8934679867");
		grdMap.put("fromName", "Bucky Barnes");
		grdMap.put("fromStreet", "123 Main St");
		grdMap.put("fromCity", "Atlanta");
		grdMap.put("fromState", "GA");
		grdMap.put("fromZip", "30326");
		grdMap.put("toName", "Luke Skywalker");
		grdMap.put("toStreet", "1111 Star Way");
		grdMap.put("toCity", "Dusty");
		grdMap.put("toState", "CA");
		grdMap.put("toZip", "90008");
		grdMap.put("height", "7");
		grdMap.put("width", "5");
		grdMap.put("depth", "6");
		
		airMap.put("type", "LA");
		airMap.put("id", "974434120");
		airMap.put("fromName", "Number One");
		airMap.put("fromStreet", "789 Onetwothree St");
		airMap.put("fromCity", "Atlanta");
		airMap.put("fromState", "GA");
		airMap.put("fromZip", "11111");
		airMap.put("toName", "Dri Nowaterr");
		airMap.put("toStreet", "89 Vacation Circle");
		airMap.put("toCity", "Drought");
		airMap.put("toState", "ID");
		airMap.put("toZip", "90008");
		airMap.put("lType", "plain");

		grd = DeliveryFactory.getDelivery(grdMap);
		air = DeliveryFactory.getDelivery(airMap);

	}

	@Test
	public void testParcelIsOnDelivery() {
		assertFalse(grd.getParcel() == null);
		assertFalse(air.getParcel() == null);

	}

	@Test
	public void testGetData() {
		String expected = "Ground Box" + "\n"
				+ "From: Bucky Barnes | 123 Main St | Atlanta, GA 30326" + "\n"
				+ "To: Luke Skywalker | 1111 Star Way | Dusty, CA 90008" + "\n";
		String actual = grd.toString();

		assertEquals(expected, actual);

	}

}
