package com.jits.core;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

/*
 * Used for checking students' cost calculations.
 * NOTE: all weights below in lbs; if < 1.0 lb, use 1.0 lb.
 * 1. time: 1.75
 *    cost: 7 * weight * 1.0
 * 2. time: 0.25
 *    cost: 1 * weight * 1.0
 * 3. time: 1.0
 *    cost: 0.5 * weight
 * 4. time: 2.0
 *    cost: 1.0 * weight
 * 5. time: 1.0
 *    cost: 4 * weight * 2.222
 *    
 * Test output should look like:
 * TEST #:
 * weight (oz):
 * delivery time:
 * shipping cost: 
 */
public class MathTest
extends TestCase
{
  // TEST 1
  public void testBoxAir1()
  {
    Address origin = new Address("William Linux", "123 First Street", 
      "El Paso", "TX", "77524");
    Address dest = new Address("Linus Windowman", "345 Second Street",
      "Kansas City", "MO", "03422");
    Map request = new HashMap();
    // Box via Air
    request.put("type", "BA");
    request.put("id", "101");
    request.put("origin", origin);
    request.put("dest", dest);
    request.put("height", "8");
    request.put("width", "10");
    request.put("depth", "10");
    
    Delivery d = DeliveryFactory.createDelivery(request);
    
    System.out.println("\nTEST 1: Box via Air 77524 -> 03422");
    System.out.println("weight: " + d.getPackage().getWeight());
    System.out.println("time: " + d.calculateDeliveryTime());
    System.out.println("cost: " + d.calculateShippingCost());
  }
  
  // TEST 2
  public void testLetterAir()
  {
    Address origin = new Address("William Linux", "123 First Street", 
      "El Paso", "TX", "70778");
    Address dest = new Address("Linus Windowman", "345 Second Street",
      "Kansas City", "MO", "72345");
    Map request = new HashMap();
    // Letter via Air
    request.put("type", "LA");
    request.put("id", "101");
    request.put("origin", origin);
    request.put("dest", dest);
    request.put("lType", Letter.FIRE);
    
    Delivery d = DeliveryFactory.createDelivery(request);
    
    System.out.println("\nTEST 2: Letter via Air 70778 -> 72345");
    System.out.println("weight: " + d.getPackage().getWeight());
    System.out.println("time: " + d.calculateDeliveryTime());
    System.out.println("cost: " + d.calculateShippingCost());
  }
  
  // TEST 3
  public void testBoxGround()
  {
    Address origin = new Address("William Linux", "123 First Street", 
      "El Paso", "TX", "32373");
    Address dest = new Address("Linus Windowman", "345 Second Street",
      "Kansas City", "MO", "50505");
    Map request = new HashMap();
    // Box via Ground
    request.put("type", "BG");
    request.put("id", "101");
    request.put("origin", origin);
    request.put("dest", dest);
    request.put("height", "12");
    request.put("width", "16");
    request.put("depth", "20");
    
    Delivery d = DeliveryFactory.createDelivery(request);
    
    System.out.println("\nTEST 3: Box via Ground 32373 -> 50505");
    System.out.println("weight: " + d.getPackage().getWeight());
    System.out.println("time: " + d.calculateDeliveryTime());
    System.out.println("cost: " + d.calculateShippingCost());
  }
  
  // TEST 4
  public void testLetterGround()
  {
    Address origin = new Address("William Linux", "123 First Street", 
      "El Paso", "TX", "00233");
    Address dest = new Address("Linus Windowman", "345 Second Street",
      "Kansas City", "MO", "42243");
    Map request = new HashMap();
    // Letter via Ground
    request.put("type", "LG");
    request.put("id", "101");
    request.put("origin", origin);
    request.put("dest", dest);
    request.put("lType", Letter.PLAIN);
    
    Delivery d = DeliveryFactory.createDelivery(request);
    
    System.out.println("\nTEST 4: Letter via Ground 00233 -> 42243");
    System.out.println("weight: " + d.getPackage().getWeight());
    System.out.println("time: " + d.calculateDeliveryTime());
    System.out.println("cost: " + d.calculateShippingCost());
  }
  
  // TEST 5
  public void testBoxAir2()
  {
    Address origin = new Address("William Linux", "123 First Street", 
      "El Paso", "TX", "88888");
    Address dest = new Address("Linus Windowman", "345 Second Street",
      "Kansas City", "MO", "44444");
    Map request = new HashMap();
    // Box via Air
    request.put("type", "BA");
    request.put("id", "101");
    request.put("origin", origin);
    request.put("dest", dest);
    request.put("height", "12");
    request.put("width", "16");
    request.put("depth", "20");
    
    Delivery d = DeliveryFactory.createDelivery(request);
    
    System.out.println("\nTEST 5: Box via Air 88888 -> 44444");
    System.out.println("weight: " + d.getPackage().getWeight());
    System.out.println("time: " + d.calculateDeliveryTime());
    System.out.println("cost: " + d.calculateShippingCost());
  }
}