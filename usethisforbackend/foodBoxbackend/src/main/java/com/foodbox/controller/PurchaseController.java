package com.foodbox.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.exception.ResourceNotFoundException;
import com.foodbox.entity.Cart;
import com.foodbox.entity.signup;
import com.foodbox.entity.purchase;
import com.foodbox.repo.cartRepo;
import com.foodbox.repo.signupRepo;
import com.foodbox.repo.purchaseRepo;
import com.foodbox.service.purchaseService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class PurchaseController {

	@Autowired
	purchaseRepo purchaseRepository;

	@Autowired
	purchaseService purchaseservice;

	@Autowired
	cartRepo cartRepository;

	@Autowired
	signupRepo signuprepo;

	@GetMapping("/purchase/byEmail/{email}")
	public List<purchase> customerOrders(@PathVariable String email) {
		return purchaseRepository.getByEmail(email);
	}

	@GetMapping("/purchase/allorders")
	public List<purchase> getAllPurchase() {
		return purchaseRepository.findAllByOrderByTransactionidAsc();
	}

	@GetMapping("/purchase/search/{keyword}")
	public List<purchase> searchPurchase(@PathVariable String keyword) {

		return purchaseRepository.searchPurchase(keyword);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/purchase")

	public Boolean create(@RequestBody purchase su) {
		purchaseRepository.save(su);
		if (purchaseservice.checkEntry(su.getProductname())) {
			return true;
		} else {
			return false;
		}
	}
}