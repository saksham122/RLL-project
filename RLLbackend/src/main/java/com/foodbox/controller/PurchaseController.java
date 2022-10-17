package com.foodbox.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.entity.Cart;
import com.foodbox.entity.signup;
import com.foodbox.entity.Purchase;
import com.foodbox.repo.CartRepository;
import com.foodbox.repo.signupRepo;
import com.foodbox.repo.PurchaseRepository;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
public class PurchaseController {
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private CartRepository cartRepository; 
	
	@Autowired
	private signupRepo sur;
	
	@GetMapping("/purchase/byEmail/{email}")
	public List<Purchase> customerOrders(@PathVariable String email) {
		return purchaseRepository.getByEmail(email);
	}
	
	@GetMapping("/purchase")
	public List<Purchase> getAllPurchase(){
		return purchaseRepository.findAllByOrderByTransactionidAsc();
	}
	
//	@DeleteMapping("/purchase/{id}")
//	public ResponseEntity<Map<String, Boolean>> deletePurchase(@PathVariable Long id) {
//		Purchase purchase = purchaseRepository.findById(id) ;
//		purchaseRepository.delete(purchase);
//		Map<String, Boolean> map = new HashMap<>();
//		map.put("deleted", Boolean.TRUE);
//		return ResponseEntity.ok(map);
//	}
	@DeleteMapping("/purchase/{id}")
	public Boolean deletePurchase(@PathVariable Long id) {
		purchaseRepository.deleteById(id);
		return true;
	}
	
	@GetMapping("/purchase/search/{keyword}")
	public List<Purchase> searchPurchase(@PathVariable String keyword){
		return purchaseRepository.searchPurchase(keyword);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/purchase")
	public ResponseEntity<Map<String, Boolean>> buyProducts(@RequestBody Map buyProdMap){
		List<Cart> cartList = cartRepository.findAll();
		Purchase purchase = new Purchase();
		String cust_email=(String)buyProdMap.get("email");
		signup customer = sur.findByEmail(cust_email);
		String transId = (String)buyProdMap.get("transactionId");
		for(Cart cl:cartList) {
			java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
			long min=100000;long max=999999;long b = (long)(Math.random()*(max-min+1)+min);
			purchase.setId(b);
			purchase.setDop(date);
			purchase.setSu(customer);
			String name = cl.getF().getFoodname();
			purchase.setProductname(name);
			purchase.setQuantity(cl.getQuantity());
			purchase.setTotalcost(cl.getPrice());
			purchase.setTransactionid(transId);
			purchaseRepository.save(purchase);
		}
		Map<String, Boolean> map = new HashMap<>();
		map.put("created",Boolean.TRUE);
		return ResponseEntity.ok(map);
	}
}
