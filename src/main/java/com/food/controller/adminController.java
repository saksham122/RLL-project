package com.food.controller;

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


import com.food.bean.admin;
import com.food.bean.food;
import com.food.repo.adminRepo;
import com.food.service.adminService;
import com.food.service.foodService;

@RestController
public class adminController {
	
	@Autowired
	adminService adminservice;
	
	@Autowired
	adminRepo adminrepo;
	
	@Autowired
	foodService foodservice;
	
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
	
}