package com.lama.mse.coursiers.orders.kafka;

import com.lama.mse.coursiers.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.lama.mse.coursiers.orders.model.Order;

import java.util.List;

@Component
public class KafkaIO {


	@Autowired
	private OrderService orderService;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public KafkaIO() {

	}

	public void sendConsultedOredrMessage(String orderjson) {
		kafkaTemplate.send("order-consulted", orderjson);
	}

	public void sendEstimateLocationMessage(Order order, int distance) {
		String startLocation = order.getDeliveryLocation();
		String endLocation = startLocation;
		String startEndLocation = startLocation + ";" + endLocation;
		kafkaTemplate.send("estimate-distance", startEndLocation);
		int sendDistance = 10;
		if (sendDistance >= distance) order.setAroundMe(true);
		orderService.saveOrder( order );
	}


	public void deliveredOrderCoursier(String orderID) {
		Order order = orderService.findById(Integer.parseInt(orderID));
		order.setDelivered( true );
		orderService.saveOrder( order );
		kafkaTemplate.send("order-delivered", orderID);
	}


	public void notifyAccidentOnOrder(String emailCause) {
		kafkaTemplate.send("order-delivered", emailCause); //envoie le String en forme "email;cause"
	}


	/*@KafkaListener(topics = "consult-coursier-orders-aroundme",
			topicPartitions = {@TopicPartition(topic = "consult-coursier-orders-aroundme", partitions = {"0"})})
	public List<Order> consultCoursierOrders(String email, int distance, Acknowledgment acknowledgment) {
		List<Order> orders = (List<Order>) orderService.findAll();
		orders.forEach( order1 -> kafkaTemplate.sendEstimateLocationMessage(order1, distance));
		List<Order> ordersNearBy = orderService.getOrdersAroundMe();
		acknowledgment.acknowledge();
		return ordersNearBy;
	}*/



	/*public void sendDeletedOrderMessage(String orderjson) {
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
	}*/

}