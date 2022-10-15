package com.foodbox.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class food {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String foodname;
	public String cuisinetype;
	public float price;
	public String offers;
	public String description;
	public String status;
	public int getId() {
		return id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public String getCuisinetype() {
		return cuisinetype;
	}
	public void setCuisinetype(String cuisinetype) {
		this.cuisinetype = cuisinetype;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getOffers() {
		return offers;
	}
	public void setOffers(String offers) {
		this.offers = offers;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
		
}
