package com.jits.factory;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.jits.core.Delivery;
import com.jits.core.Dimensionable;
import com.jits.core.Protectable;
import com.jits.core.Protection;
import com.jits.factory.DeliveryFactory;

public class DeliveryFactoryTest {
	private DeliveryFactory factory;
	private Delivery letterAir;
	private Delivery letterGround;
	private Delivery boxAir;
	private HashMap<String, String> letterAirMap = new HashMap<String, String>();
	private HashMap<String, String> letterGroundMap = new HashMap<String, String>();
	private HashMap<String, String> boxAirMap = new HashMap<String, String>();

	@Before
	public void setUp() throws Exception {
		factory = new DeliveryFactory();

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
		
		letterAir = factory.getDelivery(letterAirMap);
		letterGround = factory.getDelivery(letterGroundMap);
		boxAir = factory.getDelivery(boxAirMap);

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
		assertEquals(5, ((Dimensionable) boxAir.getParcel()).height());
	}

}
