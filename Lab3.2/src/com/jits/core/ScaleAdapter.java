package com.jits.core;

import com.thirdParty.calibration.MailScale;

class ScaleAdapter implements Weighable {

	@Override
	public double weigh(Object obj) {
		return Math.ceil(new MailScale().calculateWeight(obj));
	}
	
	static ScaleAdapter getInstance() {
		return new ScaleAdapter();
	}

}
