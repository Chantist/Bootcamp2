package com.jits.core;

abstract class Parcel {
	
	private int width;
	private int height;
	private int depth;
	private long id;
	Address fromAddress;
	Address toAddress;

	Parcel(int w, int h, int d, long id) {
		this.setId(id);
		this.setWidth(w);
		this.setHeight(h);
		this.setDepth(d);
	}
	
	String getDimensions() {
		return "Dimensions: " + this.getWidth() + ", " + this.getHeight() + ", " + this.getDepth(); 
	}

	private void setId(long id) {
		this.id = id;
	}

	long getId() {
		return this.id;
	}

	int getWidth() {
		return width;
	}

	private void setWidth(int width) {
		this.width = width;
	}

	int getHeight() {
		return height;
	}

	private void setHeight(int height) {
		this.height = height;
	}

	int getDepth() {
		return depth;
	}

	private void setDepth(int depth) {
		this.depth = depth;
	}

	Address getFromAddress() {
		return fromAddress;
	}

	private void setFromAddress(Address fromAddress) {
		this.fromAddress = fromAddress;
	}

	Address getToAddress() {
		return toAddress;
	}

	private void setToAddress(Address toAddress) {
		this.toAddress = toAddress;
	}

}
