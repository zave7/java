package com.kitri.dto;

import java.io.Serializable;

public class Child extends Parent {
	private String c;
	public Child() {
		super();
		setP("Parent Instance Variable");
	}
	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}
	
}
