package com.lama.mse.coursiers.orders.consultation.app.service;

import ch.qos.logback.core.net.server.Client;
import com.lama.mse.coursiers.orders.consultation.app.model.Coursier;
import com.lama.mse.coursiers.orders.consultation.app.repository.ICoursierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//@Transactionnal
@Service("ClientService")
public class CoursierService implements ICoursierService{

    @Autowired
    private ICoursierRepository repository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void CoursierService() {}


    @Override
    public Coursier findByEmail(String email) {
        //	return Repository.findByEmail(email)
        return null;
    }

}








