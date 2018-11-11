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
	//String json
	@KafkaListener(id="createFood",topics = "create-food",topicPartitions = { @TopicPartition(topic="create-food", partitions = {"0"})})
	@SendTo(value= {"topic"})
	public String createFood(String foodjson) {
		Food food = new Gson().fromJson(foodjson, Food.class);
		foodService.store(food);
		Logs.infoln("Listened create-food");
		return "Food " + food.getName() + " created.";
	}

	@KafkaListener(id="createOrder",topics = "create-order", topicPartitions = { @TopicPartition(topic = "create-order", partitions = {"0"})})
	@SendTo(value= {"topic"})
	public String createOrder(String orderJson) {
		Order order = new Gson().fromJson(orderJson, Order.class);
		orderService.store(order);
		kafkaIO.sendOrderCreated(orderJson);
		Logs.infoln("Listened create-order");
		return "Order of " + order.getClientMail() + " created.";
	}
	
	@KafkaListener(id="createRestaurant",topics="create-restaurant", topicPartitions = { @TopicPartition(topic = "create-restaurant", partitions = {"0"})})
	@SendTo(value= {"topic"})
	public String createRestaurant(String restaurantJson) {
		Restaurant restaurant = new Gson().fromJson(restaurantJson, Restaurant.class);
		restaurantService.store(restaurant);
		kafkaIO.sendRestaurantCreated(restaurantJson);
		Logs.infoln("Listened create-restaurant");
		return "Restaurant " + restaurant.getName() + " created.";
	}

}