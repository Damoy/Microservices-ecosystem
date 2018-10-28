package com.lama.mse.coursiers.accounts.modification.kafka;

import com.lama.mse.coursiers.accounts.modification.model.Coursier;

public interface IKafkaIO {

    public void sendConsultedCoursierMessage(Coursier coursier);
    public void sendDeletedCoursierMessage(Coursier coursier);
    public void sendModifiedEmailMessage(Coursier coursier);
    public void sendModifiedPhoneNumberMessage(Coursier coursier);
    public void sendModifiedNameMessage(Coursier coursier);
    public void sendModifiedLocationMessage(Coursier coursier);

}



