package com.lama.mse.coursiers.orders.modification.app.kafka;

import com.lama.mse.coursiers.orders.modification.app.model.Order;

public interface IKafkaIO {

    public void sendDeletedOrder(Order order);

    public void sendModifedClientMail(Order order);

    public void sendModifiedRestaurantName(Order order);

    public void sendModifiedDeliveryLocation(Order order);

    public void sendModifiedFoodNames(Order order);
}
