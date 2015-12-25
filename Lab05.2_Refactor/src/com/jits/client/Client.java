package com.jits.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import com.jits.controller.Controller;
import com.jits.core.Address;
import com.jits.transfer.Confirmation;

public class Client {
	public static void main(String[] args) throws Exception {
		// create controller
		Controller controller = new Controller();

		// build request from UI
		Map request = buildRequest();

		// use controller to do all the actor actions
		// send request to controller, get Confirmation back ("Pending")
		Confirmation conf = controller.handleRequest(request);

		// display the pending delivery info
		System.out.println(conf);

		System.out.print("Would you like to proceed with the shipment? [y/n] ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String response = reader.readLine();

		if (response.equalsIgnoreCase("y")) {
			System.out.println(controller.proceed()); // ("Delivered")
		} else {
			System.out.println(controller.cancel()); // ("Cancelled")
		}
	}

	private static Map buildRequest() {
		// create delivery request from UI
		Map request = new HashMap();

		Address origin = new Address("Jason Rossington", "456 Fell Street", "San Francisco", "CA", "94102");
		request.put("origin", origin);

		Address dest = new Address("Edwin Lancelot", "1 Joegia Place", "Atlanta", "GA", "33333");
		request.put("dest", dest);

		request.put("type", "LA");
		request.put("id", "1001");
		// this is read out of the map only for boxes
		request.put("height", "14");
		request.put("width", "10");
		request.put("depth", "22");
		// this is read out of the map only for letters
		request.put("lType", "plain");
		return request;
	}
}