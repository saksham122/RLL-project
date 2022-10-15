package com.food.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.bean.Login;
import com.food.repo.LoginRepository;

@Service
public class LoginService{
	
	@Autowired
	LoginRepository loginrepository;
	
	public String signIn(Login login) 
	{
		Optional<Login> result = loginrepository.findById(login.getEmailId());
		if(result.isPresent()) 
		{
			Login ll = result.get();
			if(ll.getPassword().equals(login.getPassword()))
			{
				return "User Successfully Login";
				
			}
			else 
			{
				return "Invalid password";
			}
		}
		else 
		{
			return "Invalid Emailid";
		}
		
	}
	
	public String signUp(Login login) 
	{
		Optional<Login> result = loginrepository.findById(login.getEmailId());
		if(result.isPresent()) 
		{
			return "EmailId already Exist";
			
		}
		
		else 
		{
			loginrepository.save(login);
			return "Account created successfully";
		}
		
	}
	
	
}