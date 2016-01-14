package com.jits.controller;

import java.util.Map;
import com.jits.core.Delivery;
import com.jits.core.DeliveryFactory;
import com.jits.transfer.Confirmation;

public class Controller {
	private Delivery d;

	public Confirmation handleRequest(Map request) {
		// create Delivery, perform calculations, review it
		// Delivery now stores computed values after the calcXXX methods run
		d = DeliveryFactory.createDelivery(request);
		d.calculateDeliveryTime();
		d.calculateShippingCost();
		return d.review();
	}

	public Confirmation proceed() {
		return d.ship();
	}

	public Confirmation cancel() {
		return d.cancel();
	}
}