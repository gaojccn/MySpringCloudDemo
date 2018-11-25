package com.gaojc.serviceprovider.controller;

import com.gaojc.serviceprovider.entity.User;
import com.gaojc.serviceprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable(name = "id") Integer id) {
        return userService.getUser(id);
    }

    @GetMapping("/add")
    void addUser(){
        User user=new User(1,"gaojc","gaojc","12@12.com");

        userService.addUser(user);
    }
}
