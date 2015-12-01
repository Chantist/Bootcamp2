package com.jits.core;

import java.util.ArrayList;

public class ProtectedMethodTest extends ArrayList<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String doThis(){
		
		
		this.removeRange(2, 3);
		return super.toString();
	}

}
