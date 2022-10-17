package com.addtocart;



import org.springframework.stereotype.Service;

import com.addtocart.entity.Product;
import com.addtocart.repo.ProductRepository;

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