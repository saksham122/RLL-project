package com.foodbox.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	@Id
	private long id;
	private int quantity;
	private float price;
	@OneToOne
	private food f;
	
	
	public Cart(long id, int quantity, float price, food f) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.f = f;
	}
	
	
	public Cart() {
		super();
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}


	public food getF() {
		return f;
	}


	public void setF(food f) {
		this.f = f;
	}
	
	
}

