package com.jits.core;

 class Box extends Parcel implements Dimensionable, Insurable {

	private Dimension dimension;
	private boolean insurance;

	Box(Address from, Address to, int h, int w, int d, long id, boolean insurance) {
		
		super(from, to, id);
		this.setDimension(new Dimension(h, w, d));
		this.setInsurance(insurance);

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
	
	@Override
	public double volume() {
		return this.height() * this.width() * this.depth();
	}
	
	@Override
	public boolean getInsurance() {
		return this.insurance;
	}
	
	private void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}
	
}
