package com.foodbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.entity.food;

@Repository
public interface foodRepo extends JpaRepository<food, Integer>{

}
