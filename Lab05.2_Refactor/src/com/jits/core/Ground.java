package com.jits.core;

import com.jits.util.ZoneUtility;

class Ground
extends Delivery
{
  // Delivery must have a Package (HAS-A)
  Ground(Package pkg)
  {
    super(pkg);
  }
  
  // delivery time is calculated in units of days (not rounded)
  // based on number of time zones travelled
  public double calculateDeliveryTime()
  {
    double deliveryTime = 0.0;
    
    // get number of timezones
    int timeZones = ZoneUtility.timeZoneDiff(
      this.getPackage().getOrigin().getPostalCode(),
      this.getPackage().getDestination().getPostalCode());
    if (timeZones == 0)  // same timezone = 1 day
    {
      deliveryTime = 1;
    }
    else
    {
      deliveryTime = timeZones * 2;
    }
    this.setDeliveryTime(deliveryTime);
    return deliveryTime;
  }
}