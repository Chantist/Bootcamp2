package com.jits.core;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.jits.transfer.Confirmation;

public class ConfirmationTest
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
  
  public void testConfirmation()
  {
    Map request = new HashMap();
    
    // Box via Air
    request.put("type", "BA");
    request.put("id", "111");
    request.put("origin", origin);
    request.put("dest", dest);
    request.put("height", "6");
    request.put("width", "12");
    request.put("depth", "3");
    
    // use factory to create Delivery
    Delivery d = DeliveryFactory.createDelivery(request);
    
    // perform rest of actor's tasks
    d.calculateDeliveryTime();
    d.calculateShippingCost();
    
    Confirmation conf = d.review();
    assertEquals("Pending", conf.getStatus());
    assertEquals("com.jits.core.Box", conf.getPackageType());
    assertEquals("com.jits.core.Air", conf.getDeliveryType());
    assertEquals(2*d.getPackage().getWeightLbs()*1.0, conf.getCost(), .001);
    assertEquals(0.5, conf.getDeliveryTime(), .001);
    
    conf = d.ship();
    assertEquals("Delivered", conf.getStatus());
    
    conf = d.cancel();
    assertEquals("Cancelled", conf.getStatus());
    
    // System.out.println(conf);
  }
}