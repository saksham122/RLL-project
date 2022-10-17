package com.food.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.bean.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    public Customer getCustomerByEmailAndName(String email,String name);
}
