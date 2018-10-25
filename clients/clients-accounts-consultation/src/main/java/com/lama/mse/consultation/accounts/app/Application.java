package com.lama.mse.consultation.accounts.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.restaurants.consultation.food.app",
		"com.lama.mse.restaurants.consultation.food.controller",
		"com.lama.mse.restaurants.consultation.food.model",
		"com.lama.mse.restaurants.consultation.food.kafka",
		"com.lama.mse.restaurants.consultation.food.repository",
		"com.lama.mse.restaurants.consultation.food.service"
})
@EnableMongoRepositories("com.lama.mse.restaurants.consultation.food.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}
