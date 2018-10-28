package com.lama.mse.coursiers.orders.consultation.app.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.lama.mse.coursiers.orders.consultation.app.model.Order;

@Component
public class KafkaIO implements IKafkaIO{

	private KafkaTemplate<String, Order> kafkaTemplate;
	private KafkaTemplate<String, String> kafkaTemplateString;


	public KafkaIO(){
		
	}

	@Override
	public void sendConsultedOredrMessage(Order order){
		kafkaTemplate.send("order-consulted", order);

	}

	@Override
	public void sendEstimateLocationMessage(Order order){
		String startLocation = order.getDeliveryLocation();
		String endLocation = startLocation;
		String startEndLocation = startLocation + ";" + endLocation;
		kafkaTemplateString.send("estimate-distance", startEndLocation);
	}


}
