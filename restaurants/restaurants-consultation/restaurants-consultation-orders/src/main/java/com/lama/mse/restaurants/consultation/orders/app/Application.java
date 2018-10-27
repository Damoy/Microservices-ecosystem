package com.lama.mse.restaurants.consultation.orders.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.restaurants.consultation.orders.app",
		"com.lama.mse.restaurants.consultation.orders.controller",
		"com.lama.mse.restaurants.consultation.orders.kafka",
		"com.lama.mse.restaurants.consultation.orders.model",
		"com.lama.mse.restaurants.consultation.orders.repository",
		"com.lama.mse.restaurants.consultation.orders.service"
})
@EnableMongoRepositories("com.lama.mse.restaurants.consultation.orders.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}
