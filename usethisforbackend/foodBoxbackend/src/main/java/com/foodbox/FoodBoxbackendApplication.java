package com.foodbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="com.food")
@EntityScan(basePackages="com.foodbox.entity")
@EnableJpaRepositories(basePackages="com.foodbox.repo")
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.foodbox")
public class FoodBoxbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodBoxbackendApplication.class, args);
	}

}
