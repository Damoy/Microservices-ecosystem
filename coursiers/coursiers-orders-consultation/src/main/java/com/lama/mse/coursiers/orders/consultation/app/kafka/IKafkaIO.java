package com.lama.mse.coursiers.orders.consultation.app.kafka;


import com.lama.mse.coursiers.orders.consultation.app.model.Coursier;

public interface IKafkaIO {

    public void sendConsultedCOursier(Coursier coursier);

}



