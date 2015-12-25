package com.jits.core;

public class Address
{
  private String name;
  private String street;
  private String city;
  private String state;
  private String postalCode;

  public Address(String name, String street, String city, String state, String postalCode)
  {
    this.setName(name);
    this.setStreet(street);
    this.setCity(city);
    this.setState(state);
    this.setPostalCode(postalCode);
  }

  public String getStreet()
  {
    return street;
  }
  public void setStreet(String street)
  {
    this.street = street;
  }

  public String getCity()
  {
    return city;
  }
  public void setCity(String city)
  {
    this.city = city;
  }

  public String getPostalCode()
  {
    return postalCode;
  }
  public void setPostalCode(String postalCode)
  {
    this.postalCode = postalCode;
  }

  public String getState()
  {
    return state;
  }
  public void setState(String state)
  {
    this.state = state;
  }

  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }

  public String toString()
  {
    StringBuffer addressInfo = new StringBuffer(100);
    addressInfo.append( 
      "\n  Name: " + this.getName() + 
      "\n  Street: " + this.getStreet() + 
      "\n  City: " + this.getCity() + 
      "\n  State: " + this.getState() + 
      "\n  Postal Code: " + this.getPostalCode());

    return addressInfo.toString();
  }
}