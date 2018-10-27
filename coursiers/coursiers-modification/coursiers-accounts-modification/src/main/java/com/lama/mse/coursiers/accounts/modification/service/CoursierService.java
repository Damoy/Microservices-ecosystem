package com.lama.mse.coursiers.accounts.modification.service;

import ch.qos.logback.core.net.server.Client;

import com.lama.mse.coursiers.accounts.modification.model.Coursier;
import com.lama.mse.coursiers.accounts.modification.repository.ICoursierRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service("CoursierService")
public class CoursierService implements ICoursierService{

    @Autowired
    private ICoursierRepository repository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public CoursierService() {
    	
    }

    @Override
    public Coursier findByEmail(String email) {
    	List<Coursier> coursiers = repository.findByMail(email);
    	if(coursiers == null || coursiers.isEmpty()) return null;
    	return coursiers.get(0);
    }

}








