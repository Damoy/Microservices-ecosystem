package com.lama.mse.coursiers.accounts.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lama.mse.coursiers.accounts.model.Coursier;

import java.util.List;


public interface ICoursierRepository extends MongoRepository<Coursier, String> {


    public List<Coursier> findByEmail(String mail);


}
