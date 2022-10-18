package com.foodbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.entity.Cart;
import com.foodbox.repo.cartRepo;

@Service
public class cartService {
	
	@Autowired
	cartRepo cartrepo;
	
	public Cart addtocart(Cart c) {
		return cartrepo.save(c);
		
	}

}