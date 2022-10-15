package com.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.bean.admin;
import com.food.repo.adminRepo;

@Service
public class adminService {
	@Autowired
	private adminRepo adminrepo;
	
	public Boolean verifyAdmin(String email, String password){
		List<admin> admin = adminrepo.findAll();
		for(admin ad : admin){
			if(ad.getEmail().equals(email) && ad.getPassword().equals(password)) { 
				return true;
			}
		}
		return false;
	}
	public Boolean checkEntry(String email) {
		List<admin> admin = adminrepo.findAll();
		for(admin ad : admin){
			if(ad.getEmail().equals(email) ) { 
				return true;
			}
		}
		return false;
	}

}