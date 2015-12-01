package com.jits.core;

class Box extends Parcel {
	private int height;
	private int width;
	private int depth;

	Box(Address origin, Address destination, long id, int height, int width,
			int depth) {
		super(origin, destination, id);
		this.setHeight(height);
		this.setWidth(width);
		this.setDepth(depth);
	}

	int getHeight() {
		return height;
	}

	void setHeight(int height) {
		this.height = height;
	}

	int getWidth() {
		return width;
	}

	void setWidth(int width) {
		this.width = width;
	}

	int getDepth() {
		return depth;
	}

	void setDepth(int depth) {
		this.depth = depth;
	}

	public String toString() {
		return super.toString() + "\nHeight: " + this.getHeight() + "\nWidth: "
				+ this.getWidth() + "\nDepth: " + this.getDepth();
	}
}