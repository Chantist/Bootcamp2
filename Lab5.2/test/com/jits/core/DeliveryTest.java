package com.jits.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.jits.transfer.ConfirmationBean;

public class DeliveryTest {

	private Delivery grd;
	private Delivery air;
	private Delivery rail;
	private Map<String, String> railMap = new HashMap<String, String>();
	private Map<String, String> grdMap = new HashMap<String, String>();
	private Map<String, String> airMap = new HashMap<String, String>();
	private NumberFormat formatter = new DecimalFormat("#0.00");

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
		grdMap.put("insurance", "true");

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
		airMap.put("toZip", "10008");
		airMap.put("lType", "plain");

		railMap.put("type", "LR");
		railMap.put("id", "974434120");
		railMap.put("fromName", "Number One");
		railMap.put("fromStreet", "789 Onetwothree St");
		railMap.put("fromCity", "Atlanta");
		railMap.put("fromState", "GA");
		railMap.put("fromZip", "31111");
		railMap.put("toName", "Dri Nowaterr");
		railMap.put("toStreet", "89 Vacation Circle");
		railMap.put("toCity", "Drought");
		railMap.put("toState", "ID");
		railMap.put("toZip", "90008");
		railMap.put("lType", "plain");

		grd = DeliveryFactory.getDelivery(grdMap);
		air = DeliveryFactory.getDelivery(airMap);
		rail = DeliveryFactory.getDelivery(railMap);

		formatter.setRoundingMode(RoundingMode.DOWN);

	}

	@Test
	public void testParcelIsOnDelivery() {

		assertFalse(grd.getParcel() == null);
		assertFalse(air.getParcel() == null);

	}

	@Test
	public void testGetData() {

		assertEquals(true, grd.toString().contains("Ground Box"));
		assertEquals(true, grd.toString().contains("Time until delivery: 3.0 days"));
		assertEquals(true, grd.toString().contains("From: Bucky Barnes | 123 Main St | Atlanta, GA 30326"));
		assertEquals(true, grd.toString().contains("To: Luke Skywalker | 1111 Star Way | Dusty, CA 90008"));

	}

	@Test
	public void testAirDeliveryTime() {

		double expected = .25;
		double actual = air.calculateDeliveryTime();
		assertEquals(expected, actual, .001);
	}

	@Test
	public void testGroundDeliveryTime() {

		double expected = 3;
		double actual = grd.calculateDeliveryTime();
		assertEquals(expected, actual, .001);
	}

	@Test
	public void testAirCost() {

		double expectedNotRounded = air.calculateZoneDifference() * (air.getParcel().getWeight() / 16)
				* (air.getParcel().volume()) * 1.75;

		assertEquals(Double.parseDouble(formatter.format(expectedNotRounded)), air.cost(), .001);
	}

	@Test
	public void testGroundCost() {

		double expectedNotRounded = grd.calculateZoneDifference() * (grd.getParcel().getWeight() / 16) * 1.1 - 0;

		assertEquals(Double.parseDouble(formatter.format(expectedNotRounded)), grd.cost(), .001);
	}

	@Test
	public void testReview() {

		ConfirmationBean review = grd.review();

		assertEquals(grd.getStatus(), review.getStatus());
		assertEquals(grd.getParcel().getFrom(), review.getOrigin());
		assertEquals(grd.getParcel().getTo(), review.getDest());
		assertEquals(grd.calculateDeliveryTime(), review.getDeliveryTime(), .001);
		assertEquals(grd.cost(), review.getCost(), .001);
		assertEquals(grd.getParcel().getWeight(), review.getWeight(), .001);
		assertEquals(grd.getClass().getSimpleName(), review.getDeliveryType());
		assertEquals(grd.getParcel().getClass().getSimpleName(), review.getPackageType());

	}

	@Test
	public void testRailDeliveryTime() {
		assertEquals(1, rail.calculateZoneDifference(), .001);
		assertEquals(10, rail.calculateDeliveryTime(), .001);
	}

	@Test
	public void testRailCost() {
		assertEquals(5, rail.cost(), .001);
	}

	@Test
	public void testConfirmationBeanLoggedToStorage() {
		rail.review();
		ConfirmationBean result = null;

		try (XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream("Storage.xml")))) {
			result = (ConfirmationBean) d.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		assertEquals(rail.cost(), result.getCost(), .001);
		assertEquals(rail.getParcel().getWeight(), result.getWeight(), .001);
		assertEquals(rail.getParcel().getFrom().toString(), result.getOrigin().toString());
		assertEquals(rail.getParcel().getTo().toString(), result.getDest().toString());

	}

}
