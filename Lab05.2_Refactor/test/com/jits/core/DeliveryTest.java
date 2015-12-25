package com.jits.core;

import junit.framework.TestCase;

public class DeliveryTest
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
  
  // review/ship/cancel all return Confirmation objects now
  /*
  public void testLetterAir()
  {
    Package p1 = new Letter(origin, dest, 3, Letter.FIRE);
    Delivery airDelivery = new Air(p1);
    assertEquals("Ship com.jits.core.Letter by air?", airDelivery.review());
    assertEquals("Shipped com.jits.core.Letter by air.", airDelivery.ship());
    assertEquals("Delivery cancelled.", airDelivery.cancel());
  }
  
  public void testBoxGround()
  {
    Package p1 = new Box(origin, dest, 2, 8, 22, 4);
    Delivery groundDelivery = new Ground(p1);
    assertEquals("Ship com.jits.core.Box by ground?", groundDelivery.review());
    assertEquals("Shipped com.jits.core.Box by ground.", groundDelivery.ship());
    assertEquals("Delivery cancelled.", groundDelivery.cancel());
  }
  */
  
  public void testDeliveryTimeBoxAir()
  {
    // going from zone 1 to 3
    Package p1 = new Box(origin, dest, 2, 8, 22, 4);
    Delivery airDelivery = new Air(p1);
    assertEquals(2*.25, airDelivery.calculateDeliveryTime(), .001);
    
    // try another set of postal codes: 1 to 8
    p1.getDestination().setPostalCode("88888");
    assertEquals(7*.25, airDelivery.calculateDeliveryTime(), .001);
    
    // same-zone delivery has zoneDiff of 1: 1 to 1
    p1.getDestination().setPostalCode("11111");
    assertEquals(1*.25, airDelivery.calculateDeliveryTime(), .001);
  }
  
  public void testDeliveryTimeLetterGround()
  {
    // going from timezone ET to CT: 1 timezone
    Package p1 = new Letter(origin, dest, 11, Letter.FIRE);
    Delivery groundDelivery = new Ground(p1);
    assertEquals(1*2, groundDelivery.calculateDeliveryTime(), .001);
    
    // ET to PT: 3 timezones
    p1.getDestination().setPostalCode("99999");
    assertEquals(3*2, groundDelivery.calculateDeliveryTime(), .001);
    
    // ET to ET: same timezone means 1 day
    p1.getDestination().setPostalCode("22222");
    assertEquals(1, groundDelivery.calculateDeliveryTime(), .001);
  }
  
  /* WORKS: made private in Ground
  public void testTimeZones()
  {
    Package p1 = new Letter(origin, dest, 11, Letter.FIRE);
    Ground groundDelivery = new Ground(p1);
    assertEquals(1, groundDelivery.timeZones());
    p1.getDestination().setPostalCode("88888");
    assertEquals(3, groundDelivery.timeZones());
    p1.getDestination().setPostalCode("66666");
    assertEquals(2, groundDelivery.timeZones());
    p1.getDestination().setPostalCode("11111");
    assertEquals(0, groundDelivery.timeZones());
  }
  */
}