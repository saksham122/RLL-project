package com.foodbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodbox.entity.Cart;

public interface cartRepo extends JpaRepository<Cart, Long> {

}