package com.food.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Table
public class Product{

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	int price;
	String foodName;
	String cuisineType,offers,about;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public String getOffers() {
		return offers;
	}
	public void setOffers(String offers) {
		this.offers = offers;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
}

