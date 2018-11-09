package com.lama.mse.coursier.account.repository;

import com.lama.mse.coursier.account.model.Coursier;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;


public interface ICoursierRepository extends MongoRepository<Coursier, String> {


    public List<Coursier> findByEmail(String mail);


}
