package com.jits.core;

import junit.framework.TestCase;

public class PackageTest
extends TestCase
{
  private Address origin;
  private Address dest;

  public void setUp()
  {
    origin = new Address("William Linux", "123 First Street",
      "El Paso", "TX", "12345");
    dest = new Address("Linus Windowman", "345 Second Street",
      "Kansas City", "MO", "34567");
  }

  public void testWeighPackage()
  {
    Package p1 = new Letter(origin, dest, 1, Letter.PLAIN);
    Package p2 = new Box(origin, dest, 2, 6, 9, 22);
    // before weighing
    assertTrue(-1 == p1.getWeight());
    assertTrue(-1 == p2.getWeight());
    // after weighing
    p1.weighPackage();
    p2.weighPackage();
    assertFalse(-1 == p1.getWeight());
    assertFalse(-1 == p2.getWeight());

    // see what the weights are for boxes and letters
    // System.out.println("Letter weighs: " + p1.getWeight());
    // System.out.println("Box weighs: " +    p2.getWeight());
  }

  public void testWeighPackageRealWeight()
  {
    Package p1 = new Letter(origin, dest, 1, Letter.PLAIN);
    double weight = p1.weighPackage();
    assertEquals(weight, p1.getWeight(), .001);
  }
}