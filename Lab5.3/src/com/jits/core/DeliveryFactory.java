package com.jits.core;

import java.util.Map;

import com.jits.cost.AirCost;
import com.jits.cost.GroundCost;
import com.jits.cost.RailCost;

public abstract class DeliveryFactory {

	private static Map<String, Object> map;

	public static Delivery getInstance(Map<String, Object> letterAirMap) {
		DeliveryFactory.map = letterAirMap;

		return DeliveryFactory.determineDeliveryType();

	}

	private static Delivery determineDeliveryType() {

		Delivery rtn = null;
		char deliveryType = ((String) DeliveryFactory.map.get("type")).charAt(1);
		Parcel parcel = DeliveryFactory.determineParcelType();

		switch (deliveryType) {
		case 'A':

			rtn = new Air(parcel);
			rtn.setCalculator(
					new AirCost(rtn.calculateZoneDifference(), rtn.getParcel().getWeight(), rtn.getParcel().volume()));
			break;
		case 'G':

			rtn = new Ground(parcel);
			rtn.setCalculator(new GroundCost(rtn.calculateZoneDifference(), rtn.getParcel().getWeight(),
					rtn.getToZone(), rtn.getFromZone()));
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
		long id = Long.parseLong(((String) DeliveryFactory.map.get("id")));
		char parcelType = ((String) DeliveryFactory.map.get("type")).charAt(0);

		Address origin = ((Address) DeliveryFactory.map.get("origin"));

		Address destination = ((Address) DeliveryFactory.map.get("dest"));

		switch (parcelType) {
		case 'L':
			rtn = new Letter(origin, destination,
					Protection.valueOf(((String) DeliveryFactory.map.get("lType")).toUpperCase()), id);
			break;
		case 'B':
			rtn = new Box(origin, destination, Integer.parseInt(((String) DeliveryFactory.map.get("height"))),
					Integer.parseInt(((String) DeliveryFactory.map.get("width"))),
					Integer.parseInt(((String) DeliveryFactory.map.get("depth"))), id,
					Boolean.parseBoolean(((String) DeliveryFactory.map.get("insured"))));
		}

		return rtn;
	}

}
