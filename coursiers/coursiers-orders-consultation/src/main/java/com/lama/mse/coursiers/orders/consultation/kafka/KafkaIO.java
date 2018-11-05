package com.lama.mse.coursiers.orders.consultation.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.lama.mse.coursiers.orders.consultation.model.Order;

import java.util.concurrent.ExecutionException;

@Component
public class KafkaIO implements IKafkaIO{

//	@Autowired
//	private KafkaTemplate<String, Order> kafkaTemplate;
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplateString;

	public KafkaIO(){

	}

	@Override
	public void sendConsultedOredrMessage(Order order){
//		kafkaTemplate.send("order-consulted", order);

	}

	 @Override
	    public void sendEstimateLocationMessage(Order order, int distance) {
	        String startLocation = order.getDeliveryLocation();
	        String endLocation = startLocation;
	        String startEndLocation = startLocation + ";" + endLocation;
	        ListenableFuture<SendResult<String, String>> result = kafkaTemplateString.send( "estimate-distance", startEndLocation );
	        try {
	            SendResult<String, String> sendResult = result.get();
	            int sendDistance = 10;
	            if (sendDistance >= distance ) order.setNearby(true);
	        } catch (ExecutionException e) {
	            e.printStackTrace();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
}


