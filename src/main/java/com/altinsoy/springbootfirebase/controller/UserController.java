package com.altinsoy.springbootfirebase.controller;

import com.altinsoy.springbootfirebase.model.Order;
import com.altinsoy.springbootfirebase.model.User;
import com.altinsoy.springbootfirebase.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("firebase-api/")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("getAllUser")
    public List<User> getAllUser() throws ExecutionException, InterruptedException {
        List<User> users = userService.getAllUser();
        return users;
    }

    @PostMapping("saveUser")
    public ResponseEntity<String> saveUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        userService.saveUser(user);
        return ResponseEntity.ok().body("OK");
    }

    @PostMapping("userDetails/{name}")
    public User getUserDetails(@PathVariable String name) throws ExecutionException, InterruptedException {
        User user = userService.getUserDetails(name);
        return user;
    }

    @PostMapping("saveOrder")
    public ResponseEntity<String> saveOrder(@RequestBody Order order) throws ExecutionException, InterruptedException {
        userService.saveOrder(order);
        return ResponseEntity.ok().body("OK");
    }

}
