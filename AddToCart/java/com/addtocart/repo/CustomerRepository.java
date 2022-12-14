package com.addtocart.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.addtocart.entity.*;
import org.springframework.stereotype.Repository;



@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    public Customer getCustomerByEmailAndName(String email,String name);
}
