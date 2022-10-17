package com.search.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.search.entity.Food;

public interface FoodRepo extends JpaRepository<Food,Long> {

	@Query("SELECT f FROM Food f WHERE "+"f.name LIKE CONCAT ('%',:query,'%')")
	List<Food> searchFood(String query);
	
	
}
