package com.jits.pricing;

import com.jits.util.ZoneUtility;

// public class because JITS internal mail system will use it also
public class AirCostCalculator
extends BaseCostCalculator
{
  private double volumeCuFt = 1.0;  // min. package size (and all letters)
  
  // Letter deliveries can use this ctor, default volume = 1.0
  // weight to be provided in ounces
  public AirCostCalculator(String originZip, String destZip, double weight)
  {
    super(originZip, destZip, weight);
  }
  
  // weight to be provided in ounces
  public AirCostCalculator(String originZip, String destZip, double weight, double volume)
  {
    this(originZip, destZip, weight);
    this.volumeCuFt = this.convertVolumeCuFt(volume);
  }
  
  public double calculateCost()
  {
    double cost = 0.0;
    // get number of zones
    int zoneDiff = ZoneUtility.zoneDiff(originZip, destZip);
    cost = zoneDiff * weightLbs * volumeCuFt;
    return cost;
  }
  
  private double convertVolumeCuFt(double volume)
  {
    double convertedVolume = volume/(12*12*12.0);
    if (convertedVolume < 1.0)
    {
      convertedVolume = 1.0;
    }
    return convertedVolume;
  }
}