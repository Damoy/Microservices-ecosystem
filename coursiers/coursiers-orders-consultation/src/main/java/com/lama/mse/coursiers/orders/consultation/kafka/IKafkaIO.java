package com.lama.mse.coursiers.orders.consultation.kafka;

import com.lama.mse.coursiers.orders.consultation.model.Order;

public interface IKafkaIO {

    public void sendConsultedOredrMessage(Order order);
    public void sendEstimateLocationMessage(Order order, int distance);

    }
