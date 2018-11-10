package com.lama.mse.restaurants.consultation.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.restaurants.consultation.app",
		"com.lama.mse.restaurants.consultation.controller",
		"com.lama.mse.restaurants.consultation.kafka",
		"com.lama.mse.restaurants.consultation.model",
		"com.lama.mse.restaurants.consultation.repository",
		"com.lama.mse.restaurants.consultationservice",
})
@EnableMongoRepositories("com.lama.mse.restaurants.consultation.repository")

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
}
