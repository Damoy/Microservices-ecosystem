package com.lama.mse.coursiers.orders.consultation.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.coursiers.orders.consultation.controller", 
		"com.lama.mse.coursiers.orders.consultation.kafka", 
		"com.lama.mse.coursiers.orders.consultation.model"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}
