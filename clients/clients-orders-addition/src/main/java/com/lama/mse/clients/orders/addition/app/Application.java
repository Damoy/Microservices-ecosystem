package com.lama.mse.clients.orders.addition.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.clients.orders.addition.app",
		"com.lama.mse.clients.orders.addition.controller",
		"com.lama.mse.clients.orders.addition.kafka", 
		"com.lama.mse.clients.orders.addition.model", 
		"com.lama.mse.clients.orders.addition.repository", 
		"com.lama.mse.clients.orders.addition.service"
})
@EnableMongoRepositories(basePackages = {
		"com.lama.mse.clients.orders.addition.repository"
})
public class Application {

	public static void main(String[] args){
		SpringApplication.run(Application.class);
	}
	
}
