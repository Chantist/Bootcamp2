package com.jits.core;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.jits.core.Delivery;
import com.jits.core.Dimensionable;
import com.jits.core.Protectable;
import com.jits.core.Protection;

public class DeliveryFactoryTest {

	private Delivery letterAir;
	private Delivery letterGround;
	private Delivery boxAir;
	private Delivery boxGround;
	private Map<String, String> letterAirMap = new HashMap<String, String>();
	private Map<String, String> letterGroundMap = new HashMap<String, String>();
	private Map<String, String> boxAirMap = new HashMap<String, String>();
	private Map<String, String> boxGroundMap = new HashMap<String, String>();

	@Before
	public void setUp() throws Exception {

		letterAirMap.put("type", "LA");
		letterAirMap.put("id", "87");
		letterAirMap.put("toName", "John Doe");
		letterAirMap.put("toStreet", "76 Street Lane");
		letterAirMap.put("toCity", "Anywhere");
		letterAirMap.put("toState", "CA");
		letterAirMap.put("toZip", "56789");
		letterAirMap.put("fromName", "Jane Doe");
		letterAirMap.put("fromStreet", "123 Main St.");
		letterAirMap.put("fromCity", "Somewhere");
		letterAirMap.put("fromState", "GA");
		letterAirMap.put("fromZip", "12345");
		letterAirMap.put("lType", "plain");

		letterGroundMap.put("type", "LG");
		letterGroundMap.put("id", "87");
		letterGroundMap.put("toName", "John Doe");
		letterGroundMap.put("toStreet", "76 Street Lane");
		letterGroundMap.put("toCity", "Anywhere");
		letterGroundMap.put("toState", "CA");
		letterGroundMap.put("toZip", "56789");
		letterGroundMap.put("fromName", "Jane Doe");
		letterGroundMap.put("fromStreet", "123 Main St.");
		letterGroundMap.put("fromCity", "Somewhere");
		letterGroundMap.put("fromState", "GA");
		letterGroundMap.put("fromZip", "12345");
		letterGroundMap.put("lType", "plain");

		boxAirMap.put("type", "BA");
		boxAirMap.put("id", "87");
		boxAirMap.put("toName", "John Doe");
		boxAirMap.put("toStreet", "76 Street Lane");
		boxAirMap.put("toCity", "Anywhere");
		boxAirMap.put("toState", "CA");
		boxAirMap.put("toZip", "56789");
		boxAirMap.put("fromName", "Jane Doe");
		boxAirMap.put("fromStreet", "123 Main St.");
		boxAirMap.put("fromCity", "Somewhere");
		boxAirMap.put("fromState", "GA");
		boxAirMap.put("fromZip", "12345");
		boxAirMap.put("height", "5");
		boxAirMap.put("width", "8");
		boxAirMap.put("depth", "10");
		boxAirMap.put("insurance", "true");

		boxGroundMap.put("type", "BG");
		boxGroundMap.put("id", "87");
		boxGroundMap.put("toName", "John Doe");
		boxGroundMap.put("toStreet", "76 Street Lane");
		boxGroundMap.put("toCity", "Anywhere");
		boxGroundMap.put("toState", "CA");
		boxGroundMap.put("toZip", "56789");
		boxGroundMap.put("fromName", "Jane Doe");
		boxGroundMap.put("fromStreet", "123 Main St.");
		boxGroundMap.put("fromCity", "Somewhere");
		boxGroundMap.put("fromState", "GA");
		boxGroundMap.put("fromZip", "12345");
		boxGroundMap.put("height", "5");
		boxGroundMap.put("width", "8");
		boxGroundMap.put("depth", "10");
		boxGroundMap.put("insurance", "false");

		letterAir = DeliveryFactory.getDelivery(letterAirMap);
		letterGround = DeliveryFactory.getDelivery(letterGroundMap);
		boxAir = DeliveryFactory.getDelivery(boxAirMap);
		boxGround = DeliveryFactory.getDelivery(boxGroundMap);

	}

	@Test
	public void testLetterAir() {
		assertEquals(87, letterAir.getParcel().getId());
		assertEquals(Protection.PLAIN, ((Protectable) letterAir.getParcel()).protection());
		assertEquals(true, letterAir.getParcel().getFrom().toString().contains("Jane Doe"));
		assertEquals(true, letterAir.getParcel().getTo().toString().contains("John Doe"));
	}

	@Test
	public void testDeliveryTypes() {
		assertEquals("Air", letterAir.getClass().getSimpleName());
		assertEquals("Ground", letterGround.getClass().getSimpleName());
	}

	@Test
	public void testBoxAir() {
		assertEquals("Box", boxAir.getParcel().getClass().getSimpleName());
		assertEquals(true, ((Insurable) boxAir.getParcel()).getInsurance());
		assertEquals(5, ((Dimensionable) boxAir.getParcel()).height());
	}

	@Test
	public void testBoxGround() {
		assertEquals("Box", boxGround.getParcel().getClass().getSimpleName());
		assertEquals(false, ((Insurable) boxGround.getParcel()).getInsurance());
		assertEquals(8, ((Dimensionable) boxGround.getParcel()).width());
	}

}
