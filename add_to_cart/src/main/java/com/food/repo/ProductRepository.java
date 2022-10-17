package com.food.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.food.bean.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
