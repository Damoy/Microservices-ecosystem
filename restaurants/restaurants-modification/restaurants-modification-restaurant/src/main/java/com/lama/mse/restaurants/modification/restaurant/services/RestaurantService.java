package com.lama.mse.restaurants.modification.restaurant.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama.mse.restaurants.modification.restaurant.model.Restaurant;


@Service("RestaurantService")
public class RestaurantService  {

   @Autowired
   private IRestaurantRepository restaurantRepository;

   public RestaurantService() {

   }


   public void register(Restaurant restaurant){
        restaurantRepository.insert(restaurant);
   }
   
}
