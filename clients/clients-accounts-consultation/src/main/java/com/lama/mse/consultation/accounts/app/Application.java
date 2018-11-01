package com.lama.mse.consultation.accounts.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.consultation.accounts.app",
		"com.lama.mse.restaurants.consultation.accounts.controller",
		"com.lama.mse.restaurants.consultation.accounts.model",
		"com.lama.mse.restaurants.consultation.accounts.kafka",
		"com.lama.mse.restaurants.consultation.accounts.repository",
		"com.lama.mse.restaurants.consultation.accounts.service"
})
@EnableMongoRepositories("com.lama.mse.restaurants.consultation.food.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}
