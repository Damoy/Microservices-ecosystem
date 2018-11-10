package com.lama.mse.restaurants.controller.app;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.restaurants.controller.app",
		"com.lama.mse.restaurants.controller",
		"com.lama.mse.restaurants.controller.kafka",
})
public class Application {

	public static void main(String[] args){
		SpringApplication.run(Application.class);
	}
	
}
