package com.lama.mse.coursiers.orders.consultation.controller;


import com.lama.mse.coursiers.orders.consultation.kafka.IKafkaIO;
import com.lama.mse.coursiers.orders.consultation.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/MSE/COURSIER")
public class OrderController {


    private static OrderController instance = null;

    /*@Autowired
    private IKafkaIO kafkaIO;

    @Autowired
    private IOrderRepository orderRepository;*/

    @Autowired
    public OrderController() {
        instance = this;
    }

    /*//TO DO
    @RequestMapping(value = "/ODERS", method = RequestMethod.POST)
    public ResponseEntity createOrderEntryPoint(@RequestBody Order order, @PathVariable int distance) {
        orderRepository.findAll().stream().forEach( order1 -> kafkaIO.sendEstimateLocationMessage(order1));

        return new ResponseEntity<>("Order created", HttpStatus.ACCEPTED);
//		ListenableFuture<SendResult<String, Order>> future = kafkaIO.sendHaveToCreateOrderMessage(order);
//		future.addCallback(new ListenableFutureCallback<SendResult<String, Order>>() {
//
//			@Override
//			public void onSuccess(SendResult<String, Order> arg0) {
//				arg0.getProducerRecord().
//			}
//
//			@Override
//			public void onFailure(Throwable arg0) {
//
//			}
//		});
    }*/

    public static OrderController getInstance() {
        return instance;
    }


}

