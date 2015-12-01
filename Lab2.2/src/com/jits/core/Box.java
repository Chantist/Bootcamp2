package com.jits.core;

class Box extends Parcel {
	
	private int width;
	private int height;
	private int depth;

	Box(Address from, Address to, int w, int h, int d, long id) {
		super(from, to, id);
		this.setWidth(w);
		this.setHeight(h);
		this.setDepth(d);

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
}
