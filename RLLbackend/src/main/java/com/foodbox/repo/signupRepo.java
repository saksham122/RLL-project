package com.foodbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodbox.entity.signup;

public interface signupRepo extends JpaRepository<signup, Integer>{
	public signup findByEmail(String email);
}
