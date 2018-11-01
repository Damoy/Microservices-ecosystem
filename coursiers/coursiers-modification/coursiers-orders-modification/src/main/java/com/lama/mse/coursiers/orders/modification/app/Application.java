package com.lama.mse.coursiers.orders.modification.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.coursiers.orders.modification.app",
		"com.lama.mse.coursiers.orders.modification.controller",
		"com.lama.mse.coursiers.orders.modification.model",
		"com.lama.mse.coursiers.orders.modification.kafka",
		"com.lama.mse.coursiers.orders.modification.repository",
		"com.lama.mse.coursiers.orders.modification.service"
})
@EnableMongoRepositories("com.lama.mse.coursiers.orders.modification.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}
