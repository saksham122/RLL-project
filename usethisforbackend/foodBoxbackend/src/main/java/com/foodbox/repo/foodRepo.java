package com.foodbox.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodbox.entity.food;


@Repository
public interface foodRepo extends JpaRepository<food, Integer>{
	
	@Query("SELECT f FROM food f WHERE f.status = 'ENABLE'")
	public List<food> findAllbystatus();
	
	@Query("DELETE FROM food f where f.cuisinename=:cuisine")
	public Boolean deletecuisinename(String cuisine);
	@Query("SELECT f FROM food f WHERE (f.status LIKE 'yes') AND (f.foodname LIKE %?1%"
			+" OR f.description LIKE %?1%"
			+" OR f.price LIKE %?1%"
			+" OR f.cuisinename LIKE %?1%)")
	public List<food> homeSearch(String keyword);
	
	@Query("SELECT f FROM food f WHERE f.category LIKE 'veg' AND f.status LIKE 'yes'")
	public List<food> getVeg();
	
	@Query("SELECT f FROM food f WHERE f.category LIKE 'nonveg' AND f.status LIKE 'yes'")
	public List<food> getNonVeg();
	
}
