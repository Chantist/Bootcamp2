package com.jits.core;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.jits.pricing.GroundCostCalculator;

public class DeliveryFactoryTest
extends TestCase
{
  private Address origin;
  private Address dest;
  
  public void setUp()
  {
    origin = new Address("William Linux", "123 First Street",
      "El Paso", "TX", "12345");
    dest = new Address("Linus Windowman", "345 Second Street",
      "Kansas City", "MO", "34567");
  }
  
  /*
   * "delivery request" map structure:
   * key      value type
   * ---      ----------
   * type     String     (enum would be better)
   * id       String
   * origin   Address
   * dest     Address
   * lType    String     (enum would be better)
   * height   String
   * width    String
   * depth    String
   */
  
  public void testShippingCostLetterAir()
  {
    Map request1 = new HashMap();
    
    // Letter via Air
    request1.put("type", "LA");
    request1.put("id", "10");
    request1.put("origin", origin);
    request1.put("dest", dest);
    request1.put("lType", Letter.WEATHER);
    
    Delivery d = DeliveryFactory.createDelivery(request1);
    
    // 2 zones
    assertEquals(2*d.getPackage().getWeightLbs()*1.0, d.calculateShippingCost(), .001);
  }
  
  public void testShippingCostLetterGround()
  {
    dest.setPostalCode("66666");
    Map request = new HashMap();
    
    // Letter via Ground
    request.put("type", "LG");
    request.put("id", "11");
    request.put("origin", origin);
    request.put("dest", dest);
    request.put("lType", Letter.FIRE);
    
    Delivery d = DeliveryFactory.createDelivery(request);
    
    // ET to MT: 2 timezones
    assertEquals(2*d.getPackage().getWeightLbs()*1.0, d.calculateShippingCost(), .001);
  }
  
  public void testShippingCostBoxAir()
  {
    dest.setPostalCode("44444");
    Map request = new HashMap();
    
    // Box via Air
    request.put("type", "BA");
    request.put("id", "101");
    request.put("origin", origin);
    request.put("dest", dest);
    request.put("height", "60");
    request.put("width", "12");
    request.put("depth", "30");
    
    Delivery d = DeliveryFactory.createDelivery(request);
    
    // need to get Box volume for assertion
    Box b = (Box) d.getPackage();
    double volume = b.getHeight() * b.getWidth() * b.getDepth();   // >1.0
    
    // 3 zones
    assertEquals(3*d.getPackage().getWeightLbs()*volume/(12*12*12.0), d.calculateShippingCost(), .001);
  }
    
  // Tested via Delivery API. A bit painful, use factory for all other cost tests.
  public void testShippingCostBoxGround()
  {
    Package p1 = new Box(origin, dest, 2, 8, 22, 4);
    p1.weighPackage();  // shipping cost depends on weight
    Delivery groundDelivery = new Ground(p1);
    groundDelivery.setCostCalculator(
      new GroundCostCalculator(p1.getOrigin().getPostalCode(),
                               p1.getDestination().getPostalCode(),
                               p1.getWeight()));  // calc converts to lbs.
    // ET to CT: 1 timezones
    assertEquals(1*p1.getWeightLbs(), groundDelivery.calculateShippingCost(), .001);
    
    // ET to MT: 2 timezones
    p1.getDestination().setPostalCode("66666");
    groundDelivery.setCostCalculator(
      new GroundCostCalculator(p1.getOrigin().getPostalCode(),
                               p1.getDestination().getPostalCode(),
                               p1.getWeight()));  // calc converts to lbs.
    assertEquals(2*p1.getWeightLbs(), groundDelivery.calculateShippingCost(), .001);
    
    // ET to ET: same timezone means 0.5 timezones
    p1.getDestination().setPostalCode("00000");
    groundDelivery.setCostCalculator(
      new GroundCostCalculator(p1.getOrigin().getPostalCode(),
                               p1.getDestination().getPostalCode(),
                               p1.getWeight()));  // calc converts to lbs.
    assertEquals(0.5*p1.getWeightLbs(), groundDelivery.calculateShippingCost(), .001);
  }

  // these no longer needed (first factory tests)
  /*
  public void testBoxAir()
  {
    HashMap request1 = new HashMap();
    
    // Box via Air
    request1.put("type", "BA");
    request1.put("id", "10");
    request1.put("origin", origin);
    request1.put("dest", dest);
    request1.put("height", "6");
    request1.put("width", "12");
    request1.put("depth", "3");
    
    // use factory to create Delivery
    Delivery d1 = DeliveryFactory.createDelivery(request1);
    
    // make sure it's an Air and that it has a Box
    assertTrue(d1.getClass().equals(com.jits.core.Air.class));
    assertTrue(d1.getPackage().getClass().equals(com.jits.core.Box.class));
  }
  
  public void testLetterGround()
  {
    HashMap request2 = new HashMap();
    
    // Letter via Ground
    request2.put("type", "LG");
    request2.put("id", "11");
    request2.put("origin", origin);
    request2.put("dest", dest);
    request2.put("lType", Letter.WEATHER);
    
    // use factory to create Delivery
    Delivery d2 = DeliveryFactory.createDelivery(request2);
    
    // make sure it's a Ground and that it has a Letter
    assertTrue(d2.getClass().equals(com.jits.core.Ground.class));
    assertTrue(d2.getPackage().getClass().equals(com.jits.core.Letter.class));
  }
  */
  
  public void testInvalidDeliveryType()
  {
    Map badrequest = new HashMap();
    badrequest.put("type", "INVALID");
    try
    {
      DeliveryFactory.createDelivery(badrequest);
      fail("should have thrown IllegalArgumentException");
    }
    catch (IllegalArgumentException expected) {  }
  }
}