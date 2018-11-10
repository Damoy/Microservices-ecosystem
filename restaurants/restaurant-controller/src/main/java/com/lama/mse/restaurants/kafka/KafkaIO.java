package com.lama.mse.restaurants.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaIO implements IKafkaIO {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	//------------------------Consult----------------------
	@Override
	public void sendConsultRestaurant(String restaurantName) {
		kafkaTemplate.send("consult-restautant", restaurantName);
	}
	
	@Override
	public void sendConsultOrder(String restaurantName) {
		kafkaTemplate.send("consult-order", restaurantName);
	}
	
	@Override
	public void sendConsultFood(String restaurantName) {
		kafkaTemplate.send("consult-food", restaurantName);
	}
	
	@Override
	public void sendConsultFoodByCategory(String restaurantName) {
		kafkaTemplate.send("consult-category-food", restaurantName);
	}
	
	//------------------------Modif----------------------
	@Override
	public void sendEditRestaurant(String restaurantName) {
		kafkaTemplate.send("edit-restaurant", restaurantName);
	}
	
	@Override
	public void sendEditOrder(String restaurantName) {
		kafkaTemplate.send("edit-order", restaurantName);
	}
	
	@Override
	public void sendEditFood(String restaurantName) {
		kafkaTemplate.send("edit-food", restaurantName);
	}
	
	@Override
	public void sendEditFoodByCategory(String restaurantName) {
		kafkaTemplate.send("edit-category-food", restaurantName);
	}
	
	

}
