package com.food.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.bean.Login;

public interface LoginRepository extends JpaRepository<Login,String>{
	
}