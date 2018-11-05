package com.lama.mse.coursier.account.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.coursier.account.app",
		"com.lama.mse.coursier.account.kafka",
		"com.lama.mse.coursier.account.model",
		"com.lama.mse.coursier.account.repository",
		"com.lama.mse.coursier.account.service",
})
@EnableMongoRepositories("com.lama.mse.coursier.account.repository")
public class Application {

	// TODO MODULE
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
}

