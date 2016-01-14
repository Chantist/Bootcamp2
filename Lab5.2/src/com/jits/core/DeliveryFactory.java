package com.jits.core;

import java.util.Map;

import com.jits.cost.AirCost;
import com.jits.cost.GroundCost;
import com.jits.cost.RailCost;

public abstract class DeliveryFactory {

	private static Map<String, String> map;

	public static Delivery getInstance(Map<String, String> letterAirMap) {
		DeliveryFactory.map = letterAirMap;

		return DeliveryFactory.determineDeliveryType();

	}

	private static Delivery determineDeliveryType() {

		Delivery rtn = null;
		char deliveryType = DeliveryFactory.map.get("type").charAt(1);
		Parcel parcel = DeliveryFactory.determineParcelType();

		switch (deliveryType) {
		case 'A':

			rtn = new Air(parcel);
			rtn.setCalculator(
					new AirCost(rtn.calculateZoneDifference(), rtn.getParcel().getWeight(), rtn.getParcel().volume()));
			break;
		case 'G':

			rtn = new Ground(parcel);
			rtn.setCalculator(new GroundCost(rtn.calculateZoneDifference(), rtn.getParcel().getWeight(), rtn.getToZone(),
					rtn.getFromZone()));
			break;
		case 'R':

			rtn = new Rail(parcel);
			rtn.setCalculator(new RailCost(rtn.calculateZoneDifference()));
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
					Integer.parseInt(DeliveryFactory.map.get("depth")), id, Boolean.parseBoolean(map.get("insurance")));
		}

		return rtn;
	}

}
