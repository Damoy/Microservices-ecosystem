package com.lama.mse.coursiers.orders.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.lama.mse.coursiers.orders.model.Order;

import java.util.concurrent.ExecutionException;

@Component
public class KafkaIO {


    private KafkaTemplate<String, Order> kafkaTemplate;
    private KafkaTemplate<String, String> kafkaTemplateString;
    private KafkaTemplate<String, Long> kafkaTemplateLong;


    public KafkaIO() {

    }

    public void sendConsultedOredrMessage(Order order) {
        kafkaTemplate.send( "order-consulted", order );

    }

    public void sendEstimateLocationMessage(Order order, int distance) {
        String startLocation = order.getDeliveryLocation();
        String endLocation = startLocation;
        String startEndLocation = startLocation + ";" + endLocation;
        ListenableFuture<SendResult<String, String>> result = kafkaTemplateString.send( "estimate-distance", startEndLocation );
        try {
            SendResult<String, String> sendResult = result.get();
            //int sendDistance = sendResult.getProducerRecord().headers().forEach( header -> System.out.println( header.key() + ":" + header.value().toString() ) );
            int sendDistance = 10;
            if (sendDistance >= distance ) order.setAroundMe(true);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


	/*@Override
	public void sendAddOrderMessage(Order order) {
		kafkaTemplate.send("order-addition", order);
	}*/

    public void sendDeletedOrderMessage(Order order) {
        kafkaTemplate.send( "order-deleted", order );
    }

    public void sendModifedClientMailMessage(Order order) {
        kafkaTemplate.send( "order-modified-client-mail", order );
    }

    public void sendModifiedRestaurantNameMessage(Order order) {
        kafkaTemplate.send( "order-modified-restaurantName", order );
    }

    public void sendModifiedDeliveryLocationMessage(Order order) {
        kafkaTemplate.send( "order-modified-deliveryLocation", order );
    }

    public void sendModifiedFoodNamesMessage(Order order) {
        kafkaTemplate.send( "order-modified-foodName", order );
    }

    public void sendNotificationDeliverdOrderMessage(long orderId) {
        kafkaTemplateLong.send( "order-deliverd", orderId );
    }

    public void sendNotificationAccidentMessage(long orderId) {
        kafkaTemplateLong.send( "coursier-accident", orderId );
    }

}