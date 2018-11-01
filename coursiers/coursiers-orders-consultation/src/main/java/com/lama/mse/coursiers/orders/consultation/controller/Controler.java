package com.lama.mse.coursiers.orders.consultation.controller;


//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import com.lama.mse.coursiers.orders.consultation.model.Coursier;

//@RestController
//@RequestMapping("/MSE/")
public class Controler {
	
//    @RequestMapping("/coursier")
    public Coursier coursier(
//    		s@RequestParam(value="coursier", defaultValue="coursierId") String name
    		) {
        return new Coursier(45313434);
    }
}

