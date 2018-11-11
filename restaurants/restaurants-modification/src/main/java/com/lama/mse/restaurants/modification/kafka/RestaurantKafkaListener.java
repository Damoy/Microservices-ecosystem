package com.lama.mse.restaurants.modification.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.lama.mse.restaurants.modification.commons.Logs;
import com.lama.mse.restaurants.modification.model.Food;
import com.lama.mse.restaurants.modification.model.Order;
import com.lama.mse.restaurants.modification.model.Restaurant;
import com.lama.mse.restaurants.modification.service.FoodService;
import com.lama.mse.restaurants.modification.service.OrderService;
import com.lama.mse.restaurants.modification.service.RestaurantService;

@Component
public class RestaurantKafkaListener {

	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private KafkaIO kafkaIO;

	public RestaurantKafkaListener() {}

	@KafkaListener(topics = "create-food", topicPartitions = { @TopicPartition(topic="create-food", partitions = {"0"})})
	@SendTo("food-created")
	public String createFood(String foodJson) {
		foodService.store(new Gson().fromJson(foodJson, Food.class));
		kafkaIO.sendFoodCreated(foodJson);
		Logs.infoln("Listened create-food");
		return "FOOD CREATED";
	}
	
	@KafkaListener(topics = "create-order", topicPartitions = { @TopicPartition(topic = "create-order", partitions = {"0"})})
	public void createOrder(String orderJson) {
		orderService.store(new Gson().fromJson(orderJson, Order.class));
		kafkaIO.sendOrderCreated(orderJson);
		Logs.infoln("Listened create-order");
	}
	
	@KafkaListener(topics = "create-restaurant", topicPartitions = { @TopicPartition(topic = "create-restaurant", partitions = {"0"})})
	public void createRestaurant(String restaurantJson) {
		restaurantService.store(new Gson().fromJson(restaurantJson, Restaurant.class));
		kafkaIO.sendRestaurantCreated(restaurantJson);
		Logs.infoln("Listened create-restaurant");
	}
	
}