package com.lama.mse.coursiers.accounts.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.coursiers.accounts.app",
		"com.lama.mse.coursiers.accounts.kafka",
		"com.lama.mse.coursiers.accounts.model",
		"com.lama.mse.coursiers.accounts.repository",
		"com.lama.mse.coursiers.accounts.service"
})
@EnableMongoRepositories("com.lama.mse.coursiers.accounts.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
}

