package com.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="com.food")
@EntityScan(basePackages="com.food.bean")
@EnableJpaRepositories(basePackages="com.food.repo")

public class RllProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RllProjectApplication.class, args);
		
		System.out.println("Server started and Running on port 9095 ");
	}

}
