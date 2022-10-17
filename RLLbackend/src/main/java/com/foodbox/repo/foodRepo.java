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
	
}
