package com.jits.factory;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.jits.core.Delivery;
import com.jits.core.Protectable;
import com.jits.core.Protection;
import com.jits.factory.DeliveryFactory;

public class DeliveryFactoryTest {
	private DeliveryFactory factory;
	private Delivery letterAir;
	private Delivery letterGround;
	private HashMap<String, String> mapAir = new HashMap<String, String>();
	private HashMap<String, String> mapGround = new HashMap<String, String>();

	@Before
	public void setUp() throws Exception {
		factory = new DeliveryFactory();

		mapAir.put("type", "LA");
		mapAir.put("id", "87");

		mapAir.put("toName", "John Doe");
		mapAir.put("toStreet", "76 Street Lane");
		mapAir.put("toCity", "Anywhere");
		mapAir.put("toState", "CA");
		mapAir.put("toZip", "56789");

		mapAir.put("fromName", "Jane Doe");
		mapAir.put("fromStreet", "123 Main St.");
		mapAir.put("fromCity", "Somewhere");
		mapAir.put("fromState", "GA");
		mapAir.put("fromZip", "12345");
		mapAir.put("lType", "plain");
		
		mapGround.put("type", "LG");
		mapGround.put("id", "87");

		mapGround.put("toName", "John Doe");
		mapGround.put("toStreet", "76 Street Lane");
		mapGround.put("toCity", "Anywhere");
		mapGround.put("toState", "CA");
		mapGround.put("toZip", "56789");

		mapGround.put("fromName", "Jane Doe");
		mapGround.put("fromStreet", "123 Main St.");
		mapGround.put("fromCity", "Somewhere");
		mapGround.put("fromState", "GA");
		mapGround.put("fromZip", "12345");
		mapGround.put("lType", "plain");
		
		letterAir = factory.getDelivery(mapAir);
		letterGround = factory.getDelivery(mapGround);

	}

	@Test
	public void testValuesAreBeingUsedToCreateProperObjects() {
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

}
