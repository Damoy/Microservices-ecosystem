package com.lama.mse.coursiers.orders.modification.app.kafka;

import com.lama.mse.coursiers.orders.modification.app.model.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaIO implements IKafkaIO{

	private KafkaTemplate<String, Order> kafkaTemplate;
	
	public KafkaIO(){

	}


	@Override
	public void sendDeletedOrder(Order order) {
		kafkaTemplate.send("order-deleted", order);
	}

	@Override
	public void sendModifedClientMail(Order order) {
		kafkaTemplate.send("order-modified-client-mail", order);
	}

	@Override
	public void sendModifiedRestaurantName(Order order) {
		kafkaTemplate.send("order-modified-restaurantName", order);
	}

	@Override
	public void sendModifiedDeliveryLocation(Order order) {
		kafkaTemplate.send("order-modified-deliveryLocation", order);
	}

	@Override
	public void sendModifiedFoodNames(Order order) {
		kafkaTemplate.send("order-modified-foodName", order);
	}
	
}
