package com.search.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.search.entity.Food;
import com.search.service.FoodService;

@RestController
@RequestMapping("/api/food")
public class FoodController {
	private FoodService foodservice;

	public FoodController(FoodService foodservice) {
		
		this.foodservice = foodservice;
	}
	@GetMapping("/search")
	public ResponseEntity<List<Food>> searchFood(@RequestParam("query")String query){
		return ResponseEntity.ok(foodservice.searchFood(query));
		

	}
	
}
