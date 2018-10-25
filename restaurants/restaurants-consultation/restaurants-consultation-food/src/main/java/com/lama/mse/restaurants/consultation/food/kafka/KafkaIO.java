package com.lama.mse.restaurants.consultation.food.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaIO implements IKafkaIO {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public KafkaIO(){
		
	}
	
	@Override
	public void sendConsultAllFoodMessage() {
		kafkaTemplate.send("consult-food", "all");
	}

	@Override
	public void sendConsultFoodByCategoryMessage(String category) {
		kafkaTemplate.send("consult-food", category.trim());
	}

}
