package com.lama.mse.clients.orders.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.clients.orders.app",
		"com.lama.mse.clients.orders.kafka",
		"com.lama.mse.clients.orders.model",
		"com.lama.mse.clients.orders.repository", 
		"com.lama.mse.clients.orders.service"
})
@EnableMongoRepositories(basePackages = {
		"com.lama.mse.clients.orders.repository"
})
public class Application {

	public static void main(String[] args){
		SpringApplication.run(Application.class);
	}
	
}
