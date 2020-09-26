package com.org.model.beans;

public class Foods extends Item {
	public enum Vegetarian {
		YES, NO
	}
	private Vegetarian vegetarian;
	
	public Foods(int code, String name, int quantity, Vegetarian vegetarian) {
		super(code, name, quantity);
		this.vegetarian = vegetarian;
	}
	public Vegetarian getVegetarian() {
		return vegetarian;
	}
	public void setVegetarian(Vegetarian vegetarian) {
		this.vegetarian = vegetarian;
	}
	@Override
	public String toString() {
		return "Foods [vegetarian=" + vegetarian + ", toString()=" + super.toString() + "]";
	}
	
}
