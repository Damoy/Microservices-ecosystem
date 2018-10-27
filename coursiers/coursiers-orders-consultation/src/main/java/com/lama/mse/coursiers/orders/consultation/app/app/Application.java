package com.lama.mse.coursiers.orders.consultation.app.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.coursiers.orders.consultation.app",
		"com.lama.mse.coursiers.orders.consultation.kafka",
		"com.lama.mse.coursiers.orders.consultation.model",
		"com.lama.mse.coursiers.orders.consultation.repository",
		"com.lama.mse.coursiers.orders.consultation.service",
})
@EnableMongoRepositories("com.lama.mse.coursiers.orders.consultation.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
}
