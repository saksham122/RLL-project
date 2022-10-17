package com.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.bean.Customer;
import com.food.repo.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Integer isCustomerPresent(Customer customer){
        Customer customer1 = customerRepository.getCustomerByEmailAndName(customer.getEmail(),customer.getName());
        return customer1!=null ? customer1.getId(): null ;
    }
}
