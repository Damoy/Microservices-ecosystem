package com.lama.mse.coursiers.orders.modification.kafka;

import com.lama.mse.coursiers.orders.modification.model.Order;

public interface IKafkaIO {

    public void sendDeletedOrderMessage(Order order);

    public void sendModifedClientMailMessage(Order order);

    public void sendModifiedRestaurantNameMessage(Order order);

    public void sendModifiedDeliveryLocationMessage(Order order);

    public void sendModifiedFoodNamesMessage(Order order);
}
