package com.jits.core;

class Letter
extends Package
{
  static final String PLAIN = "plain";
  static final String FIRE = "fire";
  static final String WEATHER = "weather";
  
  private String letterType;

  Letter(Address origin, Address destination, long id, String letterType)
  {
    super(origin, destination, id);
    this.setLetterType(letterType);
  }

  String getLetterType()
  {
    return letterType;
  }
  void setLetterType(String letterType)
  {
    if (letterType.equalsIgnoreCase(FIRE) ||
        letterType.equalsIgnoreCase(WEATHER) ||
        letterType.equalsIgnoreCase(PLAIN))
    {
      this.letterType = letterType;
    }
    else
    {
      this.letterType = PLAIN;
    }
  }

  public String toString()
  {
    return super.toString() +
      "\nLetter Type: " + this.getLetterType();
  }
}