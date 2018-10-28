package com.lama.mse.coursiers.accounts.modification.service;

import com.lama.mse.coursiers.accounts.modification.model.Coursier;

public interface ICoursierService {


    public Coursier findByEmail(String email);

}
