package com.foodbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.entity.LoginUser;
import com.foodbox.entity.food;
import com.foodbox.entity.signup;
import com.foodbox.exception.ResourceNotFoundException;
import com.foodbox.repo.foodRepo;
import com.foodbox.repo.signupRepo;
import com.foodbox.service.foodService;
import com.foodbox.service.signupService;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class signupController {
	@Autowired
	signupRepo surepo;
	@Autowired
	signupService sus;
	@Autowired
	foodRepo foodrepo;
	@Autowired 
	foodService fs;
	
	@RequestMapping("/signup")
	public Boolean create(@RequestBody signup su) {
		System.out.println("in signup");
		surepo.save(su);
		if(sus.checkEntry(su.getEmail())) {
			return true;
			}
			else {
				return false;
			}
	}
	@RequestMapping(value ="/signin", method= RequestMethod.POST)
	public Boolean userlogin(@RequestBody LoginUser lu) {
		
		//System.out.println("userlogin");
		System.out.println(lu.getEmail());
		if(sus.verifyUser(lu.getEmail(), lu.getPassword())){
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

	@GetMapping("products/{id}")
	public ResponseEntity<food> getProductById(@PathVariable int id) {
		food product = foodrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Oops! Nothing found."));
		return ResponseEntity.ok(product);
	}
	@GetMapping("products/search/{keyword}")
	public List<food> getSearchProducts(@PathVariable String keyword) {
		return foodrepo.homeSearch(keyword);
	}
	@GetMapping("products/veg")
	public List<food> getVeg() {
		return foodrepo.getVeg();
	}

	@GetMapping("products/nonveg")
	public List<food> getNonVeg() {
		return foodrepo.getNonVeg();
	}
	@GetMapping("/food/sort/price")
    public List<food> sortByPrice(){
        return foodrepo.sortbyPrice();
    }

 

    @GetMapping("/food/sort/price/dsc")
    public List<food> sortByPriceDsc(){
        return foodrepo.sortbyPriceHigh();
    }
    
    @GetMapping("/food/sort/name")
    public List<food> sortByName(){
        return foodrepo.findAllOrderByFoodnameAsc();
    }
    
    @GetMapping("/food/sort/name/dsc")
    public List<food> sortByNameDsc(){
        return foodrepo.findAllOrderByFoodnameDsc();
    }
}
