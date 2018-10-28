package com.lama.mse.restaurants.consultation.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lama.mse.restaurants.consultation.orders.kafka.IKafkaIO;
import com.lama.mse.restaurants.consultation.orders.model.Order;
import com.lama.mse.restaurants.consultation.orders.service.IOrderService;

/**
 * Restaurant access to its orders:<br>
 * ".../MS/{restaurantName}/ORDERS"
 */
@RestController
@RequestMapping("/MS/")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Controller {

	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IKafkaIO kafkaIO;

	public Controller() {

	}

	@RequestMapping(value = "{restaurantName}/ORDERS", method = RequestMethod.GET)
	public ResponseEntity restaurantConsultItsOrders(@PathVariable String restaurantName) {
		restaurantName = restaurantName.trim();
		List<Order> restaurantOrders = orderService.getAllRestaurantsOrder(restaurantName);
		HttpStatus status = HttpStatus.OK;

		if (restaurantOrders == null || restaurantOrders.isEmpty()) {
			status = HttpStatus.NOT_FOUND;
		}

		kafkaIO.sendConsultedRestaurantFoodMessage(restaurantName);
		return new ResponseEntity(restaurantOrders, status);
	}

}
