package com.lama.mse.coursiers.orders.modification.app.kafka;

import com.lama.mse.coursiers.orders.modification.app.model.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaIO implements IKafkaIO{

	private KafkaTemplate<String, Order> kafkaTemplate;
	private KafkaTemplate<String, Long> kafkaTemplateLong;


	public KafkaIO(){

	}

	/*@Override
	public void sendAddOrderMessage(Order order) {
		kafkaTemplate.send("order-addition", order);
	}*/

	@Override
	public void sendDeletedOrderMessage(Order order) {
		kafkaTemplate.send("order-deleted", order);
	}

	@Override
	public void sendModifedClientMailMessage(Order order) {
		kafkaTemplate.send("order-modified-client-mail", order);
	}

	@Override
	public void sendModifiedRestaurantNameMessage(Order order) {
		kafkaTemplate.send("order-modified-restaurantName", order);
	}

	@Override
	public void sendModifiedDeliveryLocationMessage(Order order) {
		kafkaTemplate.send("order-modified-deliveryLocation", order);
	}

	@Override
	public void sendModifiedFoodNamesMessage(Order order) {
		kafkaTemplate.send("order-modified-foodName", order);
	}

	@Override
	public void sendNotificationDeliverdOrderMessage(long orderId) {
		kafkaTemplateLong.send( "order-deliverd", orderId);
	}

	@Override
	public void sendNotificationAccidentMessage(long orderId) {
		kafkaTemplateLong.send( "coursier-accident", orderId);
	}

}
