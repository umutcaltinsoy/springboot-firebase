package com.altinsoy.springbootfirebase.service;

import com.altinsoy.springbootfirebase.model.Order;
import com.altinsoy.springbootfirebase.model.User;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface UserService {

    List<User> getAllUser() throws ExecutionException, InterruptedException;
    String saveUser(User user) throws ExecutionException, InterruptedException;

    User getUserDetails(String name) throws ExecutionException, InterruptedException;

    String saveOrder(Order order) throws ExecutionException, InterruptedException;
}
