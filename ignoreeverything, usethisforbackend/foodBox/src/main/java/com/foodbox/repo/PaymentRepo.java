package com.foodbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodbox.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}