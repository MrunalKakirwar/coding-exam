package com.org.model.beans;

public class Electronics extends Item{
	private int warranty;
	
	public Electronics(int code, String name, int quantity, int warranty) {
		super(code, name, quantity);
		this.warranty = warranty;
	}

	@Override
	public String toString() {
		return "Electronics [warranty=" + warranty + ", toString()=" + super.toString() + "]";
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	
}
