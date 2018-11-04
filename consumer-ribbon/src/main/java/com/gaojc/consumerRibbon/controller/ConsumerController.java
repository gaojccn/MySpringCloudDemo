package com.gaojc.consumerRibbon.controller;

import com.gaojc.consumerRibbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/consume")
    public String hi(@RequestParam(name = "name") String name) {
        return helloService.sayHi(name);
    }

    @GetMapping(value = "/getUsers")
    public String hi() {
        return helloService.getUsers();
    }
}
