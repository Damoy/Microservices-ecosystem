package com.lama.mse.database.restaurant.repository;

import com.lama.dsa.model.client.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Database Restaurant storing. 
 */
public interface IClientRepository extends MongoRepository<Client, String> {

	

	

}
