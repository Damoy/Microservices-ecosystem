package com.lama.mse.coursiers.orders.consultation.app.model;

import org.springframework.data.annotation.Id;

//import javax.persistence.Entity;


//@Entity
public class Coursier {

    //@Id
    private long id;
    private String name;
    private int phone;
    private String email;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}