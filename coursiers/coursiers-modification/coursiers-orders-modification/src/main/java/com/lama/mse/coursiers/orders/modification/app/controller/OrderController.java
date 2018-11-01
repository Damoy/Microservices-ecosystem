package com.lama.mse.coursiers.orders.modification.app.controller;


import com.lama.mse.coursiers.orders.modification.kafka.IKafkaIO;
import com.lama.mse.coursiers.orders.modification.model.Order;
import com.lama.mse.coursiers.orders.modification.repository.IOrderRepository;
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
    private IOrderRepository orderRepository;

    @Autowired
    public OrderController() {
        instance = this;
    }


    @RequestMapping(value = "/DELIVERD{orderId}", method = RequestMethod.POST)
    public ResponseEntity notifyDeliverdOrder(@RequestBody Order order, @PathVariable int orderId) {
        kafkaIO.sendNotificationDeliverdOrderMessage(orderId);
        return new ResponseEntity<>("Order " + order.getId() +" delivered", HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/ACCIDENT{cause}", method = RequestMethod.POST)
    public ResponseEntity notifyAccident(@RequestBody Order order, @PathVariable String cause) {
        kafkaIO.sendNotificationAccidentMessage(order.getId());
        return new ResponseEntity<>("Accident : " + cause + " unabeling food delivery with id :" + order.getId() , HttpStatus.ACCEPTED);
    }


    public static OrderController getInstance() {
        return instance;
    }


}

