package com.jits.util;

public class ZoneUtility
{
  public static int zoneDiff(String originZip, String destZip)
  {
    // get 1st digits of each zipcode and compute zone difference
    int startZone = Integer.parseInt(originZip.substring(0,1));
    int endZone = Integer.parseInt(destZip.substring(0,1));
    int zoneDiff = Math.abs(startZone - endZone);
    if (zoneDiff == 0)  // same zone = zoneDiff of 1
    {
      zoneDiff = 1;
    }
    return zoneDiff;
  }
  
  public static int timeZoneDiff(String originZip, String destZip)
  { 
    int startTimeZone = getTimeZoneNumber(originZip);
    int endTimeZone = getTimeZoneNumber(destZip);
    return Math.abs(startTimeZone - endTimeZone);
  }
  
  /*
   * we "number" each timezone for ease of computing time zone difference
   * 1  ET  0-2
   * 2  CT  3-5
   * 3  MT  6-7
   * 4  PT  8-9
   * ***
   * REFACTOR: This could be implemented differently, e.g., a lookup table (Map):
   * key=1st zipcode digit (0-9)  value=time zone number (1-4)
   * DECIDED to leave it for now.
   */
  private static int getTimeZoneNumber(String zip)
  {
    int timeZone = 0;

    int firstDigit = Integer.parseInt(zip.substring(0,1));
    switch (firstDigit)
    {
    case 0: case 1: case 2:
      timeZone = 1;
      break;
    case 3: case 4: case 5:
      timeZone = 2;
      break;
    case 6: case 7:
      timeZone = 3;
      break;
    case 8: case 9: case 10:
      timeZone = 4;
      break;
    }
    return timeZone;
  }
}