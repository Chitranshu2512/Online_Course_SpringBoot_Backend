package com.cg.springbootmicroservice2purchase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringBootMicroservice2PurchaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroservice2PurchaseApplication.class, args);
	}

}
