package com.search.service;

import java.util.List;

import com.search.entity.Food;

public interface FoodService {

	List<Food> searchFood(String query);

	
}
