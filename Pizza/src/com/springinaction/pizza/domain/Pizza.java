package com.springinaction.pizza.domain;

import java.util.List;

public class Pizza {
	

	private String size;
	private List<Toppings> toppings;

	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public List<Toppings> getToppings() {
		return toppings;
	}
	public void setToppings(List<Toppings> toppings) {
		this.toppings = toppings;
	}
	
	

}
