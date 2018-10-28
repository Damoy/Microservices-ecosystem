package com.lama.mse.coursiers.orders.consultation.app.kafka;

import com.lama.mse.coursiers.orders.consultation.app.model.Order;

public interface IKafkaIO {

    public void sendConsultedOredrMessage(Order order);

}
