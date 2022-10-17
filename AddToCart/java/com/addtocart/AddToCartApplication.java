package com.addtocart;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.addtocart.repo.*")
@ComponentScan( "com.addtocart.*" )
@EntityScan({"com.addtocart.entity.Customer","com.addtocart.entity.Order","com.addtocart.entity.Product","com.addtocart.entity.ShoppingCart"}) 
public class AddToCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddToCartApplication.class, args);
	}

}
