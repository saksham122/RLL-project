package com.foodbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.entity.Cart;
import com.foodbox.entity.food;
import com.foodbox.entity.signup;
import com.foodbox.repo.cartRepo;
import com.foodbox.repo.foodRepo;
import com.foodbox.repo.signupRepo;
import com.foodbox.service.cartService;

@CrossOrigin(origins = "http://localhost:9095")
@RestController

public class CartController{
	@Autowired
	cartService cartservice;
	
	@Autowired
	foodRepo fr;
	
	@Autowired
	cartRepo cr;
	
	@Autowired
	signupRepo sr;
	@PostMapping("/addcart")
	public boolean addToCart(@RequestBody Cart cart) 
	{
		Cart f1 = cartservice.addtocart(cart);
		if (f1!=null) {
			return true;
		}
		else {
			return false;
		}
	}
}