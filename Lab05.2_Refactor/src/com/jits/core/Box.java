package com.jits.core;

class Box
extends Package
implements Dimensions
{
  private int height;
  private int width;
  private int depth;

  Box(Address origin, Address destination, long id, int height, int width, int depth)
  {
    super(origin, destination, id);
    this.setHeight(height);
    this.setWidth(width);
    this.setDepth(depth);
  }

  public int getHeight()
  {
    return height;
  }
  public void setHeight(int height)
  {
    this.height = height;
  }

  public int getWidth()
  {
    return width;
  }
  public void setWidth(int width)
  {
    this.width = width;
  }

  public int getDepth()
  {
    return depth;
  }
  public void setDepth(int depth)
  {
    this.depth = depth;
  }
  
  public String toString()
  {
    return super.toString() + 
      "\nHeight: " + this.getHeight() + 
      "\nWidth: " + this.getWidth() +
      "\nDepth: " + this.getDepth();
  }
}