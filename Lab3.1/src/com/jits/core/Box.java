package com.jits.core;

 public class Box extends Parcel implements Dimensionable {

	private Dimension dimension;

	public Box(Address from, Address to, int h, int w, int d, long id) {
		
		super(from, to, id);
		this.setDimension(new Dimension(h, w, d));

	}

	private Dimension getDimension() {
		return dimension;
	}

	private void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	@Override
	public int height() {
		return this.getDimension().getHeight();
	}

	@Override
	public int width() {
		return this.getDimension().getWidth();
	}

	@Override
	public int depth() {
		return this.getDimension().getDepth();
	}
}
