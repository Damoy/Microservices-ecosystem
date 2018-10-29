package com.lama.mse.coursiers.orders.consultation.kafka;

import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

@Component
public class KafkaIO implements IKafkaIO{



}


	/*private KafkaTemplate<String, Order> kafkaTemplate;
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
		ListenableFuture<SendResult<String, String>> result  = kafkaTemplateString.send  ("estimate-distance", startEndLocation);
		try {
			SendResult<String, String> sendResult = result.get();
			sendResult.getProducerRecord().headers().forEach(header -> System.out.println(header.key() + ":" + header.value().toString()));
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/



		/*// confirm if producer produced successfully
		SendResult<String, Model> sendResult = sendAndReceive.getSendFuture().get();
		//print all headers
		sendResult.getProducerRecord().headers().forEach(header -> System.out.println(header.key() + ":" + header.value().toString()));
		// get consumer record
		ConsumerRecord<String, Model> consumerRecord = sendAndReceive.get();
		// return consumer value
		return consumerRecord.value(); }*/


