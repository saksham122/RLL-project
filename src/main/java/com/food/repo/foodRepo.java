package com.food.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.bean.food;

@Repository
public interface foodRepo extends JpaRepository<food, Integer> {

}
