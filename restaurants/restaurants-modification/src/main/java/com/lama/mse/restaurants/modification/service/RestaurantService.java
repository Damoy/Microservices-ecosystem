package com.lama.mse.restaurants.modification.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama.mse.restaurants.modification.model.Restaurant;



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
