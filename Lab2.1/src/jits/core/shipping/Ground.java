package jits.core.shipping;

class Ground extends Delivery {
	
	Ground(Parcel parcel, Address toAddress, Address fromAddress) {
		super(parcel, toAddress, fromAddress);
	}

}
