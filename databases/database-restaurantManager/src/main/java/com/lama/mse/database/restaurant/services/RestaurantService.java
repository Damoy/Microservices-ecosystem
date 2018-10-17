package com.lama.mse.database.restaurant.service



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Collections.singletonList;

import java.util.List;

@Transactional
@Service("RestaurantService")
public class RestaurantService  {

    @Autowired
    private IRestaurantRepository clientRepository;

    public RestaurantService() {

    }


    @Override
    public Client insertRestaurant(Restaurant restaurant){
        return clientRepository.insert(client);
    }
}
