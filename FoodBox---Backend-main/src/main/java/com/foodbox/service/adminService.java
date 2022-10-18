package com.foodbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.model.Admin;
import com.foodbox.repository.AdminRepository;

@Service
public class adminService {
	@Autowired
	private AdminRepository adminrepo;
	
	public Boolean verifyAdmin(String email, String password){
		List<Admin> admin = adminrepo.findAll();
		for(Admin ad : admin){
			if(ad.getUsername().equals(email) && ad.getPassword().equals(password)) { 
				return true;
			}
		}
		return false;
	}
	public Boolean checkEntry(String email) {
		List<Admin> admin = adminrepo.findAll();
		for(Admin ad : admin){
			if(ad.getUsername().equals(email) ) { 
				return true;
			}
		}
		return false;
	}

}