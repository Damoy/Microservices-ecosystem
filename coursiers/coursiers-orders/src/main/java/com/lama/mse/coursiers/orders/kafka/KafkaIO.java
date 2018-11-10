package com.lama.mse.coursiers.orders.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.lama.mse.coursiers.orders.model.Order;

@Component
public class KafkaIO {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public KafkaIO() {

	}

	public void sendConsultedOredrMessage(String orderjson) {
		kafkaTemplate.send("order-consulted", orderjson);
	}

	public void sendEstimateLocationMessage(String orderjson, int distance) {
		Order order = new Gson().fromJson(orderjson, Order.class);
		String startLocation = order.getDeliveryLocation();
		String endLocation = startLocation;
		String startEndLocation = startLocation + ";" + endLocation;
		kafkaTemplate.send("estimate-distance", startEndLocation);
		
		int sendDistance = 10;
		if (sendDistance >= distance)
			order.setAroundMe(true);
	}

	public void sendDeletedOrderMessage(String orderjson) {
		kafkaTemplate.send("order-deleted", orderjson);
	}

	public void sendModifedClientMailMessage(String orderjson) {
		kafkaTemplate.send("order-modified-client-mail", orderjson);
	}

	public void sendModifiedRestaurantNameMessage(String orderjson) {
		kafkaTemplate.send("order-modified-restaurantName", orderjson);
	}

	public void sendModifiedDeliveryLocationMessage(String orderjson) {
		kafkaTemplate.send("order-modified-deliveryLocation", orderjson);
	}

	public void sendModifiedFoodNamesMessage(String orderjson) {
		kafkaTemplate.send("order-modified-foodName", orderjson);
	}

	public void sendNotificationDeliverdOrderMessage(String orderID) {
		kafkaTemplate.send("order-delivered", orderID);
	}

	public void sendNotificationAccidentMessage(String orderID) {
		kafkaTemplate.send("coursier-accident", orderID);
	}

}