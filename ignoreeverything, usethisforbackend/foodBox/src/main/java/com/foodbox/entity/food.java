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
	public String cuisinename;
	public float price;
	public int offers;
	public String description;
	public String status;
	public String category;

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
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
	
	public String getCuisinename() {
		return cuisinename;
	}
	public void setCuisinename(String cuisinename) {
		this.cuisinename = cuisinename;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getOffers() {
		return offers;
	}
	public void setOffers(int offers) {
		this.offers = offers;
	}
	
}
