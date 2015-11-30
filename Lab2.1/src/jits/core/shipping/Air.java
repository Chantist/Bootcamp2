package jits.core.shipping;

class Air extends Delivery {
	
	Air(Parcel parcel, Address toAddress, Address fromAddress) {
		super(parcel, toAddress, fromAddress);
	}

}
