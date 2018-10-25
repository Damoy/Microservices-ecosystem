package com.lama.mse.restaurants.modification.food.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.restaurants.modification.food.app",
		"com.lama.mse.restaurants.modification.food.kafka",
		"com.lama.mse.restaurants.modification.food.model",
		"com.lama.mse.restaurants.modification.food.repository",
		"com.lama.mse.restaurants.modification.food.service",
})
@EnableMongoRepositories(basePackages = {
		"com.lama.mse.restaurants.modification.food.repository",
})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
}
