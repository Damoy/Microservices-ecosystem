package com.lama.mse.coursiers.accounts.modification.kafka;

import com.lama.mse.coursiers.accounts.modification.model.Coursier;

public interface IKafkaIO {

    public void sendConsultedCoursierMessage(Coursier coursier);

}



