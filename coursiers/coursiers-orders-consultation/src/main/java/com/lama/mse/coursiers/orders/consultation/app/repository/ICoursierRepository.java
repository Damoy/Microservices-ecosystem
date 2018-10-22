package com.lama.mse.coursiers.orders.consultation.app.repository;

import com.lama.mse.coursiers.orders.consultation.app.model.Coursier;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ICoursierRepository extends MongoRepository<Coursier, String> {


    public List<Coursier> findByMail(String mail);


}
