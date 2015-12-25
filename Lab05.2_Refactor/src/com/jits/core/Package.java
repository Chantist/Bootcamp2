package com.jits.core;

// abstract since scale only weighs Letter or Box
abstract class Package
{
  private Address origin;
  private Address destination;
  private long id;
  private double weight = -1;  // indicates not been weighed yet

  Package(Address origin, Address destination, long id)
  {
    this.setOrigin(origin);
    this.setDestination(destination);
    this.setId(id);
  }

  double weighPackage()
  {
    ScaleAdapter adapter = new ScaleAdapter();
    double weight = adapter.weighPackage(this);
    this.setWeight(weight);
    return this.getWeight();
  }
  
  Address getOrigin()
  {
    return origin;
  }
  void setOrigin(Address origin)
  {
    this.origin = origin;
  }

  Address getDestination()
  {
    return destination;
  }
  void setDestination(Address destination)
  {
    this.destination = destination;
  }

  long getId()
  {
    return id;
  }
  void setId(long id)
  {
    this.id = id;
  }
  
  double getWeight()
  {
    return weight;
  }
  // package is weighed, cannot be set externally
  private void setWeight(double weight)
  {
    this.weight = weight;
  }
  
  /* ***
   * FOR TESTING ONLY
   * REFACTOR consideration.
   * This should possibly only be in the cost calculators or in a utility class.
   * If we keep it here, move calculation to weighPackage()
   * and store value in a field, which we return from getWeightLbs().
   * DECIDED to leave it here, not clutter up the class with another field.
  */
  double getWeightLbs()
  {
    double convertedWeight = -1;
    
    double weight = this.getWeight();
    if (weight != -1)  // we've been weighed
    {
      convertedWeight = weight/16.0;
      if (convertedWeight < 1.0)  // min. weight in lbs. is 1.0
      {
        convertedWeight = 1.0;
      }
    }
    return convertedWeight;
  }
  
  public String toString()
  {
    StringBuffer packageInfo = new StringBuffer(250);
    packageInfo.append(
      "\nID: " + this.getId() + 
      "\nWeight: " + this.getWeight() +
      "\nOrigin: " + this.getOrigin() + 
      "\nDestination: " + this.getDestination());
    
    return packageInfo.toString();
  }
}