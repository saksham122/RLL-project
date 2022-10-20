package com.foodbox.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodbox.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {
	
	//@Query("SELECT f FROM payment")
	//public List<Payment> allpayment();

}