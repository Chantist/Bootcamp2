package com.jits.core.cost;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CostTest {
	private Cost air;
	private Cost grd;

	@Test
	public void testCalculateCostAir() {
		air = new AirCost(3, 89.700, 24);
		assertEquals(58.86, air.calculateCost(), .001);
		
		air = new AirCost(4, 67, 1.9);
		assertEquals(4.64, air.calculateCost(), .001);
		
	}
	
	@Test
	public void testCalculateCostGround() {
		grd = new GroundCost(1, 45, 8, 9);
		assertEquals(0, grd.calculateCost(), .001);
		
		grd = new GroundCost(2, 78, 3, 7);
		assertEquals(10.18, grd.calculateCost(), .001);
		
	}

}
