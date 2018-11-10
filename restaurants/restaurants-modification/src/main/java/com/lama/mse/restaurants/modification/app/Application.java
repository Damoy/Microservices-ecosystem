package com.lama.mse.restaurants.modification.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.restaurants.modification.app",
		"com.lama.mse.restaurants.modification.commons",
		"com.lama.mse.restaurants.modification.kafka",
		"com.lama.mse.restaurants.modification.model",
		"com.lama.mse.restaurants.modification.repository",
		"com.lama.mse.restaurants.modification.service",
})
@EnableMongoRepositories(basePackages = {
		"com.lama.mse.restaurants.modification.repository",
})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
}
