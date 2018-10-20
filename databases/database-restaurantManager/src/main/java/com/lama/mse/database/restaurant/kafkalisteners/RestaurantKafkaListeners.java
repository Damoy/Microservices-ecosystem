package com.lama.mse.database.restaurant.businessObjectRepresentation;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;



@Component
public class RestaurantKafkaListener {

	@Autowired
	private RestaurantService restaurantService;

	public OrderKafkaListener() {
		this.shipmentService = shipmentService;
	}

	@KafkaListener(topics = "RestaurantCreation")
	public void order(Restaurant restaurant, Acknowledgment acknowledgment){
		restaurantService.register(restaurant);
		acknowledgment.acknowledge();
	}


}
