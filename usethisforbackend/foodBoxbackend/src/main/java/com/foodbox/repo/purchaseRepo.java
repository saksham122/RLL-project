package com.foodbox.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodbox.entity.purchase;

public interface purchaseRepo extends JpaRepository<purchase, Long> {
	@Query("Select p FROM purchase p WHERE p.signup.email LIKE %?1%")
	public List<purchase> getByEmail(String email);
	
	public List<purchase> findAllByOrderByTransactionidAsc();
	
	@Query("Select p FROM purchase p WHERE p.transactionid LIKE %?1%"
			+" OR p.dop LIKE %?1%"
			+" OR p.productname LIKE %?1%"
			+" OR p.signup LIKE %?1%")
	public List<purchase> searchPurchase(String keyword);
}