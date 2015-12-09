package com.jits.factory;

import java.util.Map;

import com.jits.core.Address;
import com.jits.core.Air;
import com.jits.core.Box;
import com.jits.core.Delivery;
import com.jits.core.Ground;
import com.jits.core.Letter;
import com.jits.core.Parcel;
import com.jits.core.Protection;

public abstract class DeliveryFactory {

	private static Map<String, String> map;

	public static Delivery getDelivery(Map<String, String> letterAirMap) {
		DeliveryFactory.map = letterAirMap;

		return DeliveryFactory.determineDeliveryType();

	}

	private static Delivery determineDeliveryType() {

		Delivery rtn = null;
		char deliveryType = DeliveryFactory.map.get("type").charAt(1);

		switch (deliveryType) {
		case 'A':
			rtn = new Air(DeliveryFactory.determineParcelType());
			break;
		case 'G':
			rtn = new Ground(DeliveryFactory.determineParcelType());
			break;
		}

		return rtn;
	}

	private static Parcel determineParcelType() {

		Parcel rtn = null;
		long id = Long.parseLong(DeliveryFactory.map.get("id"));
		char parcelType = DeliveryFactory.map.get("type").charAt(0);

		Address origin = new Address(DeliveryFactory.map.get("fromName"), DeliveryFactory.map.get("fromStreet"),
				DeliveryFactory.map.get("fromState"), DeliveryFactory.map.get("fromCity"),
				DeliveryFactory.map.get("fromZip"));

		Address destination = new Address(DeliveryFactory.map.get("toName"), DeliveryFactory.map.get("toStreet"),
				DeliveryFactory.map.get("toState"), DeliveryFactory.map.get("toCity"),
				DeliveryFactory.map.get("toZip"));

		switch (parcelType) {
		case 'L':
			rtn = new Letter(origin, destination, Protection.valueOf(DeliveryFactory.map.get("lType").toUpperCase()),
					id);
			break;
		case 'B':
			rtn = new Box(origin, destination, Integer.parseInt(DeliveryFactory.map.get("height")),
					Integer.parseInt(DeliveryFactory.map.get("width")),
					Integer.parseInt(DeliveryFactory.map.get("depth")), id);
		}

		return rtn;
	}

}
