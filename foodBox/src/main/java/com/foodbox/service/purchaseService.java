package com.foodbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.entity.purchase;
import com.foodbox.repo.purchaseRepo;

@Service
public class purchaseService {
	@Autowired
	purchaseRepo purchaseRepository;
	
	public Boolean checkEntry(String name) {
		List<purchase> s = purchaseRepository.findAll();
		for(purchase su : s){
			if(su.getProductname().equals(name) ) { 
				return true;
			}
		}
		return false;
	}

}