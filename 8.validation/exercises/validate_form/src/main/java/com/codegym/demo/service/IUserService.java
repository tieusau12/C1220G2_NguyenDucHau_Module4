package com.codegym.demo.service;

import com.codegym.demo.model.User;

import java.util.List;

public interface IUserService {
    void save(User user);
//    boolean checkExistEmail(String email);
//    boolean checkExistPhoneNumber(String phoneNumber);
    List<User> findAll();
}
