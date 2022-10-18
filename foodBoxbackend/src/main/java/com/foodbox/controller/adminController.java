package com.foodbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.foodbox.entity.admin;
import com.foodbox.entity.food;
import com.foodbox.repo.adminRepo;
import com.foodbox.repo.foodRepo;
import com.foodbox.service.adminService;
import com.foodbox.service.foodService;

@RestController
public class adminController {
	
	@Autowired
	adminService adminservice;
	
	@Autowired
	adminRepo adminrepo;
	
	@Autowired
	foodService foodservice;
	
	@Autowired
	foodRepo foodrepo;
	
	@RequestMapping("/adminlogin")
	public Boolean adminlogin(@RequestBody admin a) {
		
		if(adminservice.verifyAdmin(a.getEmail(), a.getPassword())){
			return true;
		}
		else{
			return false;
		}
	}
	
	@RequestMapping("/createadminaccount")
	public Boolean createAccount(@RequestBody admin a) {
		adminrepo.save(a);
		if(adminservice.checkEntry(a.getEmail())) {
		return true;
		}
		else {
			return false;
		}
	}
	@GetMapping("/getallfooddetails")
	public List<food> getall(){
		return foodservice.getAllfood();
	}
	@PostMapping("/addfood")
	public Boolean addfood(@RequestBody food f) {
		food f1 = foodservice.addFood(f);
		if(f1!=null) { 
			return true;
		}
		else {
			return false;
		}
	}
	@PutMapping("/updatefood/{id}")
	public Boolean updateFooditem(@PathVariable int id,@RequestBody food f) {
		return foodservice.updateFood(id, f);
	}
	
	@DeleteMapping("/deletefood/{id}")
	public Boolean deleteFooditem(@PathVariable int id) {
		return foodservice.deleteFood(id);
	}
//	@DeleteMapping("/deletecuisene/{id}")
//	public Boolean deleteFooditem(@PathVariable String cuisine) {
//		 foodService.deleteCuisine(cuisine);
//	}
	
}