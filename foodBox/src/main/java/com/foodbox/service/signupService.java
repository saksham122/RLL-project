package com.foodbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.entity.admin;
import com.foodbox.entity.food;
import com.foodbox.entity.signup;
import com.foodbox.repo.signupRepo;

@Service
public class signupService {
 @Autowired
 signupRepo sur;
 //signin
 public Boolean verifyUser(String email, String password){
		List<signup> s = sur.findAll();
		for(signup su : s){
			if(su.getEmail().equals(email) && su.getPassword().equals(password)) {
				System.out.println("email: "+su.getEmail()+"pwd : "+su.getPassword());
				System.out.println("email: "+email+"pwd : "+password);
				return true;
			}
			System.out.println("email: "+su.getEmail()+"pwd : "+su.getPassword());
			System.out.println("email: "+email+"pwd : "+password);
		}
		return false;
	}
 public Boolean checkEntry(String email) {
		List<signup> s = sur.findAll();
		for(signup su : s){
			if(su.getEmail().equals(email) ) { 
				return true;
			}
		}
		return false;
	}
 public Boolean updateUser(int id,signup su) {
		signup s = sur.getById(id);
		if(su.getPassword()!=null) {
			s.setPassword(su.getPassword());
		}
		if(su.getEmail()!=null) {
			s.setEmail(su.getEmail());
		}
		if(su.getName()!=null) {
			s.setName(su.getName());
		}
		if(su.getMobilenumber()!=0) {
			s.setMobilenumber(su.getMobilenumber());
		}
		if(su.getAddress()!=null){
			s.setAddress(su.getAddress());
		}
		
		
		sur.save(s);
		return true;
	}
}
