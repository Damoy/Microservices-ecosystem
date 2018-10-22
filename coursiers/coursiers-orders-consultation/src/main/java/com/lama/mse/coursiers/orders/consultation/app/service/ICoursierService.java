package com.lama.mse.coursiers.orders.consultation.app.service;

import com.lama.mse.coursiers.orders.consultation.app.model.Coursier;

public interface ICoursierService {


    public Coursier findByEmail(String email);

}
