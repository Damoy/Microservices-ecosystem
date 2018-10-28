package com.lama.mse.coursiers.orders.consultation.app.coursier;

import com.lama.mse.coursiers.orders.consultation.app.kafka.IKafkaIO;
import com.lama.mse.coursiers.orders.consultation.app.service.ICoursierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/MS/CONSULT/")
@SuppressWarnings({"rawtypes", "unchecked"})
public class CoursierController {

        @Autowired
        private IKafkaIO kafkaIO;

        @Autowired
        private ICoursierService coursierService;

        public CoursierController() {
        }

        /*@RequestMapping(value = "COURSIER/ORDERS", method = RequestMethod.GET)
        public ResponseEntity consultOrderEntryPoint() {


            category = Locale.Category.parseCategory(category.trim()).getTitle();
            List<Food> foods = foodService.getByCategory(category);
            kafkaIO.sendConsultedFoodByCategoryMessage(category);

            HttpStatus status = HttpStatus.OK;

            if(foods == null || foods.isEmpty()){
                status = HttpStatus.NOT_FOUND;
            }

            return new ResponseEntity(foods, status);*/
        }

}
