package com.food.service;

import org.springframework.stereotype.Service;

import com.food.bean.Product;
import com.food.repo.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }
}
