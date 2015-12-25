package com.jits.kiosk;

import java.util.Map;

import com.jits.core.Delivery;
import com.jits.core.DeliveryFactory;
import com.jits.transfer.IConfirmation;

public class KioskRequestHandler {

	private Delivery delivery;

	IConfirmation handleRequest(Map<String, Object> map) {
		delivery = DeliveryFactory.getInstance(map);
		delivery.calculateCost();
		delivery.calculateDeliveryTime();

		IConfirmation rtn = delivery.review();

		return rtn;
	}

	IConfirmation handleUserDecision(boolean proceedWithShipment) {
		IConfirmation rtn = null;

		if (proceedWithShipment) {
			rtn = this.proceed();
		} else {
			rtn = this.cancel();
		}

		return rtn;
	}

	private IConfirmation proceed() {
		IConfirmation rtn = delivery.ship();

		delivery.log(rtn);

		return rtn;
	}

	private IConfirmation cancel() {
		IConfirmation rtn = delivery.cancel();

		return rtn;
	}

}
