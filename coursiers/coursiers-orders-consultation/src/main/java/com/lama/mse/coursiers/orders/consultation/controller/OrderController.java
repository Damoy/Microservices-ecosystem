package com.lama.mse.coursiers.orders.consultation.controller;


import com.lama.mse.coursiers.orders.consultation.kafka.IKafkaIO;
import com.lama.mse.coursiers.orders.consultation.model.Order;
import com.lama.mse.coursiers.orders.consultation.repository.IOrderRepository;
import com.lama.mse.coursiers.orders.consultation.repository.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/MSE/COURSIER")
public class OrderController {


    private static OrderController instance = null;

    @Autowired
    private IKafkaIO kafkaIO;

    @Autowired
    private IOrderService orderService;

    @Autowired
    public OrderController() {
        instance = this;
    }

    @RequestMapping(value = "/ODERS/{distance}", method = RequestMethod.POST)
    public List<Order> createOrderEntryPoint(@RequestBody Order order, @PathVariable int distance) {
        List<Order> orders = (List<Order>) orderService.findAll();
        orders.stream().forEach( order1 -> kafkaIO.sendEstimateLocationMessage(order1, distance));
        List<Order> ordersNearBy = orderService.getOrdersNearBy();
        return ordersNearBy;
    }


    public static OrderController getInstance() {
        return instance;
    }


}

