package com.search.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.search.entity.Food;
import com.search.repository.FoodRepo;
import com.search.service.FoodService;

@Service
public class Impl implements FoodService{
	private FoodRepo foodrepo;

	@Override
	public List<Food> searchFood(String query) {
		// TODO Auto-generated method stub
		List<Food> foods=foodrepo.searchFood(query);
		
		return foods;
	}

	public Impl(FoodRepo foodrepo) {
		
		this.foodrepo = foodrepo;
	}

	

}
