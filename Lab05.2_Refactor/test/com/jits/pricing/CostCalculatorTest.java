package com.jits.pricing;

import junit.framework.TestCase;

/*
 * Tests the CostCalculators *independent* of their use by Delivery.
 * See com.jits.delivery.DeliveryFactoryTest for integrated cost testing.
 */
public class CostCalculatorTest
extends TestCase
{
  public void testGroundCostCalculator()
  {
    // ET to CT: 1 timezone
    String zip1 = "11111";
    String zip2 = "44444";
    double weight = 32;  // 2 lbs.
    CostCalculator calc = new GroundCostCalculator(zip1, zip2, weight);
    assertEquals(1*2, calc.calculateCost(), .001);
    
    // ET to PT: 3 timezones
    zip2 = "99999";
    weight = 8.0;  // 0.5 lbs., should become 1.0
    calc = new GroundCostCalculator(zip1, zip2, weight);
    assertEquals(3*1, calc.calculateCost(), .001);
    
    // ET to ET: same timezone means 0.5 timezones
    zip2 = "00000";
    weight = 20;
    calc = new GroundCostCalculator(zip1, zip2, weight);
    assertEquals(0.5*20/16.0, calc.calculateCost(), .001);
    
    weight = -1;  // IllegalStateException - cost requires weight
    try
    {
      calc = new GroundCostCalculator(zip1, zip2, weight);
      fail("Should have thrown IllegalStateException");
    }
    catch (IllegalStateException expected) { }
  }
  
  public void testAirCostCalculator()
  {
    // 5 zones with default volume of 1.0 (e.g., a letter)
    String zip1 = "44444";
    String zip2 = "99999";
    double weight = 32.0;  // 2 lbs.
    CostCalculator calc = new AirCostCalculator(zip1, zip2, weight);  // 1.0 volume
    assertEquals(5*2.0*1.0, calc.calculateCost(), .001);
    
    // this time with a specified volume
    double volume = 18*12*20;
    calc = new AirCostCalculator(zip1, zip2, weight, volume);
    assertEquals(5*2.0*(volume/(12*12*12.0)), calc.calculateCost(), .001);
    
    // same zone
    zip2 = "40000";
    weight = 4;  // .25 lbs., should become 1.0
    volume = 8*8*8;  // should become 1.0
    calc = new AirCostCalculator(zip1, zip2, weight, volume);
    assertEquals(1*1.0*1.0, calc.calculateCost(), .001);
    
    weight = -1;  // IllegalStateException - cost requires weight
    try
    {
      calc = new AirCostCalculator(zip1, zip2, weight);
      fail("Should have thrown IllegalStateException");
    }
    catch (IllegalStateException expected) { }
  }
}