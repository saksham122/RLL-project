package com.food.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.bean.admin;

@Repository
public interface adminRepo extends JpaRepository<admin, Integer> {

}
