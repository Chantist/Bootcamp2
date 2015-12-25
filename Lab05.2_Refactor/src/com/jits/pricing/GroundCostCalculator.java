package com.jits.pricing;

import com.jits.util.ZoneUtility;

// public class because JITS internal mail system will use it also
public class GroundCostCalculator
extends BaseCostCalculator
{
  // weight to be provided in ounces
  public GroundCostCalculator(String originZip, String destZip, double weight)
  {
    super(originZip, destZip, weight);
  }
  
  public double calculateCost()
  {
    double cost = 0.0;
    // get number of timezones
    double timeZones = ZoneUtility.timeZoneDiff(originZip, destZip);
    if (timeZones == 0)  // same timezone = 0.5 timezones
    {
      timeZones = 0.5;
    }
    cost = timeZones * weightLbs;    
    return cost;
  }  
}