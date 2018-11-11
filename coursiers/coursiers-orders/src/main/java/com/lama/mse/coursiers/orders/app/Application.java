package com.lama.mse.coursiers.orders.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.coursiers.orders.app",
		"com.lama.mse.coursiers.orders.kafka",
		"com.lama.mse.coursiers.orders.model",
		"com.lama.mse.coursiers.orders.repository",
		"com.lama.mse.coursiers.orders.service"})
@EnableMongoRepositories(basePackages = {
		"com.lama.mse.coursiers.orders.repository",
})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
}
