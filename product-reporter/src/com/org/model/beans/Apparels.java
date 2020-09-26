package com.org.model.beans;

public class Apparels extends Item {
	public enum Size {
		LARGE, MEDIUM, SMALL
	}
	private Size size;
	public Apparels(int code, String name, int quantity, Size size) {
		super(code, name, quantity);
		this.size = size;
	}
	
	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Apparels [size=" + size + ", toString()=" + super.toString() + "]";
	}

	
}
