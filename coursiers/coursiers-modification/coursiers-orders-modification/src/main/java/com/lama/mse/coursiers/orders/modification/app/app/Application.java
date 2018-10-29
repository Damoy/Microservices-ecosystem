package com.lama.mse.coursiers.orders.modification.app.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.coursiers.orders.modification.app",
		"com.lama.mse.coursiers.orders.modification.app.kafka",
		"com.lama.mse.coursiers.orders.modification.app.model",
		"com.lama.mse.coursiers.orders.modification.app.repository",
		"com.lama.mse.coursiers.orders.modification.app.service",
})
@EnableMongoRepositories("com.lama.mse.coursiers.orders.modification.app.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
}
