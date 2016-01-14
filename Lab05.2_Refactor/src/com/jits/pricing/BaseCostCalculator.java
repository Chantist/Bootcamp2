package com.jits.pricing;

public abstract class BaseCostCalculator
implements CostCalculator
{
  protected String originZip;
  protected String destZip;
  protected double weightLbs;
  
  // weight to be provided in ounces
  protected BaseCostCalculator(String originZip, String destZip, double weight)
  {
    this.originZip = originZip;
    this.destZip = destZip;
    this.weightLbs = this.convertWeightLbs(weight);
  }
  
  private double convertWeightLbs(double weight)
  {
    double convertedWeight = 0;
    if (weight != -1)
    {
      convertedWeight = weight/16.0;
      if (convertedWeight < 1.0)  // min. weight in lbs. is 1.0
      {
        convertedWeight = 1.0;
      }
    }
    else
    {
      throw new IllegalStateException("Package must be weighed.");
    }
    return convertedWeight;
  }
}