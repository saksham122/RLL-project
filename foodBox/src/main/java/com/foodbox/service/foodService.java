package com.foodbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.entity.food;
import com.foodbox.repo.foodRepo;

@Service
public class foodService {
	
	@Autowired
	foodRepo foodrepo;
	
	public food addFood(food f) {
		return foodrepo.save(f);
	}
	public Boolean updateFood(int id,food f) {
		food f1 = foodrepo.getById(id);
		if(f.getCuisinename()!=null) {
			f1.setCuisinename(f.getCuisinename());
		}
		if(f.getDescription()!=null) {
			f1.setDescription(f.getDescription());
		}
		if(f.getFoodname()!=null) {
			f1.setFoodname(f.getFoodname());
		}
		if(f.getOffers()!=0) {
			f1.setOffers(f.getOffers());
		}
		if(f.getPrice()!=0) {
			f1.setPrice(f.getPrice());
		}
		if(f.getStatus()!=null) {
			f1.setStatus(f.getStatus());
		}
		
		foodrepo.save(f1);
		return true;
	}
	public Boolean deleteFood(int id) {
		foodrepo.deleteById(id);
		return true;
		
	}
	public List<food> getAllfood(){
		return foodrepo.findAll();
	}
	public Boolean deleteCuisine(String cuisine) {
		return foodrepo.deletecuisinename(cuisine);
	}
	
	
}
