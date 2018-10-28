package com.lama.mse.coursiers.orders.modification.app.kafka;

import com.lama.mse.coursiers.orders.modification.app.model.Order;

public interface IKafkaIO {

    public void sendDeletedOrderMessage(Order order);

    public void sendModifedClientMailMessage(Order order);

    public void sendModifiedRestaurantNameMessage(Order order);

    public void sendModifiedDeliveryLocationMessage(Order order);

    public void sendModifiedFoodNamesMessage(Order order);
}
