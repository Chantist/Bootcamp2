package com.jits.core;

class Dimension {

	private int height;
	private int width;
	private int depth;

	public Dimension(int height, int width, int depth) {
		this.setHeight(height);
		this.setWidth(width);
		this.setDepth(depth);
	}

	int getHeight() {
		return height;
	}

	private void setHeight(int height) {
		this.height = height;
	}

	int getWidth() {
		return width;
	}

	private void setWidth(int width) {
		this.width = width;
	}

	int getDepth() {
		return depth;
	}

	private void setDepth(int depth) {
		this.depth = depth;
	}

}
