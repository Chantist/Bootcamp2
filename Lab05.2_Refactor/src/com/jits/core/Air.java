package com.jits.core;

import com.jits.util.ZoneUtility;

class Air
extends Delivery
{
  // Delivery must have a Package (HAS-A)
  Air(Package pkg)
  {
    super(pkg);
  }
  
  // delivery time is calculated in units of days (not rounded)
  // based on number of "zones" travelled
  // a "zone" is defined as the 1st digit of a zipcode
  public double calculateDeliveryTime()
  {
    double deliveryTime = 0.0;    
    // get number of zones
    int zoneDiff = ZoneUtility.zoneDiff(
      this.getPackage().getOrigin().getPostalCode(),
      this.getPackage().getDestination().getPostalCode());
    deliveryTime = zoneDiff * .25;
    
    this.setDeliveryTime(deliveryTime);
    return deliveryTime;
  }
}