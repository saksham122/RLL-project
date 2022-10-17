package com.food.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.bean.Order;



@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
