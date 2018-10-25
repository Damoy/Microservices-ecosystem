package com.lama.mse.restaurants.consultation.food.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.lama.mse.restaurants.consultation.food.service.IFoodService;

@Component
@KafkaListener
public class FoodKafkaListener {
	
	@Autowired
	private IFoodService clientService;

	public FoodKafkaListener() {
	}

	// TODO TODO
	@KafkaListener(topics = "consult-food")
	public void consultClientListener(String category, Acknowledgment acknowledgment) {
		// send to controller results ?
		acknowledgment.acknowledge();
	}

}
