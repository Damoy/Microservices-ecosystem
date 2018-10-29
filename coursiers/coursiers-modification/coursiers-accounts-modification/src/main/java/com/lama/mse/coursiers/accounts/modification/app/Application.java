package com.lama.mse.coursiers.accounts.modification.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.coursiers.accounts.modification.app",
		"com.lama.mse.coursiers.accounts.modification.kafka",
		"com.lama.mse.coursiers.accounts.modification.model",
		"com.lama.mse.coursiers.accounts.modification.repository",
		"com.lama.mse.coursiers.accounts.modification.service",
})
@EnableMongoRepositories("com.lama.mse.coursiers.accounts.modification.repository")
public class Application {

	// TODO MODULE
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
}

