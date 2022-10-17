package com.foodbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.entity.food;
import com.foodbox.entity.signup;
import com.foodbox.repo.signupRepo;
import com.foodbox.service.signupService;

@RestController
public class signupController {
	@Autowired
	signupRepo surepo;
	@Autowired
	signupService sus;
	@Autowired
	foodRepo foodrepo;
	@RequestMapping("/signup")
	public Boolean create(@RequestBody signup su) {
		surepo.save(su);
		if(sus.checkEntry(su.getEmail())) {
			return true;
			}
			else {
				return false;
			}
	}
	@RequestMapping("/signin")
	public Boolean userlogin(@RequestBody signup su) {
		
		if(sus.verifyUser(su.getEmail(), su.getPassword())){
			return true;
		}
		else{
			return false;
		}
	}
	@PutMapping("/updateuser/{id}")
	public Boolean updateFooditem(@PathVariable int id,@RequestBody signup su) {
		return sus.updateUser(id, su);
	}
	@GetMapping("/showallfood")
	public List<food> showallfood(){
		return foodrepo.findAllbystatus();
	}
}
