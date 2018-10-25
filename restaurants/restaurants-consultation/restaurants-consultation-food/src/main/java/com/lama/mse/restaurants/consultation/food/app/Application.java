package com.lama.mse.restaurants.consultation.food.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.clients.consultation.accounts.kafka",
		"com.lama.mse.clients.consultation.accounts.model",
		"com.lama.mse.clients.consultation.accounts.repository",
		"com.lama.mse.clients.consultation.accounts.service"
})
@EnableMongoRepositories("com.lama.mse.clients.consultation.accounts.repository")
public class Application {

	public static void main(String[] args) {

	}
}
