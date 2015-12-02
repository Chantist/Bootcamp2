package com.jits.factory;

import java.util.HashMap;

import com.jits.core.Address;
import com.jits.core.Air;
import com.jits.core.Delivery;
import com.jits.core.Ground;
import com.jits.core.Letter;
import com.jits.core.Parcel;
import com.jits.core.Protection;

class DeliveryFactory {

	Delivery getDelivery(HashMap<String, String> map) {

		Parcel parcel = null;
		Delivery delivery = null;
		String firstLetterOfType = map.get("type").substring(0, 1);
		String secondLetterOfType = map.get("type").substring(1, 2);

		switch (firstLetterOfType) {
		case "L":
			parcel = new Letter(
					new Address(map.get("fromName"), map.get("fromStreet"), map.get("fromState"), map.get("fromCity"),
							map.get("fromZip")),
					new Address(map.get("toName"), map.get("toStreet"), map.get("toState"), map.get("toCity"),
							map.get("toZip")),
					Protection.valueOf(map.get("lType").toUpperCase()), Long.parseLong(map.get("id")));
			break;
		}

		switch (secondLetterOfType) {
		case "A":
			delivery = new Air(parcel);
			break;
		case "G":
			delivery = new Ground(parcel);
			break;
		}

		return delivery;

	}

}
