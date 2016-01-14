package com.jits.core;

import java.util.Map;
import com.jits.pricing.AirCostCalculator;
import com.jits.pricing.CostCalculator;
import com.jits.pricing.GroundCostCalculator;

public class DeliveryFactory
{
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
  public static Delivery createDelivery(Map request)
  {
    Package pkg = null;
    Delivery delivery = null;
    CostCalculator calc = null;
    
    // extract package type and delivery type (LG,LA,BG,BA)
    String type = (String) request.get("type");

    // test for invalid type up front
    if (!(type.equals("LA") || type.equals("LG") || 
          type.equals("BA") || type.equals("BG")))
    {
      throw new IllegalArgumentException("Invalid delivery specified: " + type);
    }
    // instantiate the correct package type and weigh it 
    if (type.startsWith("L"))       // Letter
    {
      pkg = createLetter(request);
    }
    else if (type.startsWith("B"))  // Box
    {
      pkg = createBox(request);
    }
    pkg.weighPackage();
    
    // instantiate the correct delivery type and determine the cost calculator
    if (type.endsWith("G"))         // Ground
    {
      delivery = new Ground(pkg);
      
      calc = new GroundCostCalculator(
        pkg.getOrigin().getPostalCode(),
        pkg.getDestination().getPostalCode(),
        pkg.getWeight());
    }
    else if (type.endsWith("A"))    // Air
    {
      delivery = new Air(pkg);
      
      // dimensional packages must specify volume to AirCostCalculator
      if (pkg instanceof Dimensions)  // height, width, depth
      {
        Dimensions dim = (Dimensions) pkg;
        int volume = dim.getHeight() * dim.getWidth() * dim.getDepth();
        calc = new AirCostCalculator(
          pkg.getOrigin().getPostalCode(),
          pkg.getDestination().getPostalCode(),
          pkg.getWeight(),
          volume);
      }
      else // use default volume of 1.0
      {
        calc = new AirCostCalculator(
          pkg.getOrigin().getPostalCode(),
          pkg.getDestination().getPostalCode(),
          pkg.getWeight());
      }
    }
    // set the cost calculator strategy
    delivery.setCostCalculator(calc);

    return delivery;    
  }

  private static Letter createLetter(Map request)
  {
    return new Letter(
      (Address) request.get("origin"),
      (Address) request.get("dest"),
      Long.parseLong((String) request.get("id")),
      (String) request.get("lType"));
  }

  private static Box createBox(Map request)
  {
    return new Box(
      (Address) request.get("origin"), 
      (Address) request.get("dest"),
      Long.parseLong((String) request.get("id")),
      Integer.parseInt((String) request.get("height")),
      Integer.parseInt((String) request.get("width")),
      Integer.parseInt((String) request.get("depth")));
  }
}