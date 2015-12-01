package com.jits.core;

abstract class Parcel {
	
	private int width;
	private int height;
	private int depth;
	private long id;
	private Address from;
	private Address to;

	Parcel(Address from, Address to, int w, int h, int d, long id) {
		this.setId(id);
		this.setWidth(w);
		this.setHeight(h);
		this.setDepth(d);
		this.setFrom(from);
		this.setTo(to);
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

	Address getFrom() {
		return from;
	}

	private void setFrom(Address from) {
		this.from = from;
	}

	Address getTo() {
		return to;
	}

	private void setTo(Address to) {
		this.to = to;
	}

}
