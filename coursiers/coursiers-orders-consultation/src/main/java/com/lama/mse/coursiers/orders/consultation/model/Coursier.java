package com.lama.mse.coursiers.orders.consultation.model;

//import javax.persistence.Entity;
//import javax.persistence.Id;



//@Entity
public class Coursier {

//    @Id
    private long id;


    public Coursier() {
    }

    public Coursier(long id) {
        this.id = id;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}