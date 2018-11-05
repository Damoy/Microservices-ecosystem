package com.lama.mse.clients.accounts.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.clients.accounts.app",
		"com.lama.mse.clients.accounts.kafka",
		"com.lama.mse.clients.accounts.model",
		"com.lama.mse.clients.accounts.repository",		
		"com.lama.mse.clients.accounts.service",
})
@EnableMongoRepositories("com.lama.mse.clients.accounts.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}
