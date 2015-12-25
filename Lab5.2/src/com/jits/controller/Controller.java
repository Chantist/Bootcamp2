package com.jits.controller;

import java.util.Map;

import com.jits.core.Delivery;
import com.jits.core.DeliveryFactory;
import com.jits.transfer.IConfirmation;

public class Controller {

	private Delivery delivery;

	IConfirmation handleRequest(Map<String, String> map) {
		delivery = DeliveryFactory.getInstance(map);
		delivery.calculateCost();
		delivery.calculateDeliveryTime();
		
		IConfirmation rtn = delivery.review();
		
		delivery.log(rtn);

		return rtn;
	}
	
	

	private IConfirmation proceed() {
		IConfirmation rtn = delivery.ship();
		
		delivery.log(rtn);
		
		return rtn;
	}

	private IConfirmation cancel() {
		IConfirmation rtn = delivery.cancel();
		
		delivery.log(rtn);
		
		return delivery.cancel();
	}

}
