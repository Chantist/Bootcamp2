package com.jits.factory;

import java.util.HashMap;

import com.jits.core.Address;
import com.jits.core.Air;
import com.jits.core.Box;
import com.jits.core.Delivery;
import com.jits.core.Ground;
import com.jits.core.Letter;
import com.jits.core.Parcel;
import com.jits.core.Protection;

class DeliveryFactory {

	private HashMap<String, String> map;

	Delivery getDelivery(HashMap<String, String> map) {
		this.map = map;

		return this.determineDeliveryType();

	}

	private Delivery determineDeliveryType() {

		Delivery rtn = null;
		String deliveryType = this.map.get("type").substring(1, 2);
		switch (deliveryType) {
		case "A":
			rtn = new Air(this.determineParcelType());
			break;
		case "G":
			rtn = new Ground(this.determineParcelType());
			break;
		}

		return rtn;
	}

	private Parcel determineParcelType() {

		Parcel rtn = null;
		String parcelType = this.map.get("type").substring(0, 1);

		Address origin = new Address(this.map.get("fromName"), this.map.get("fromStreet"), this.map.get("fromState"),
				this.map.get("fromCity"), this.map.get("fromZip"));
		Address destination = new Address(this.map.get("toName"), this.map.get("toStreet"), this.map.get("toState"),
				this.map.get("toCity"), this.map.get("toZip"));

		Long id = Long.parseLong(this.map.get("id"));

		switch (parcelType) {
		case "L":
			rtn = new Letter(origin, destination, Protection.valueOf(this.map.get("lType").toUpperCase()), id);
			break;
		case "B":
			rtn = new Box(origin, destination, Integer.parseInt(this.map.get("height")),
					Integer.parseInt(this.map.get("width")), Integer.parseInt(this.map.get("depth")), id);
		}

		return rtn;
	}

}
