package com.gaojc.consumerFeign.controller;

import com.gaojc.consumerFeign.client.MyFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    private MyFeignClient myFeignClient;

    @Value("${headerPre}")
    public String headerPre;

    @GetMapping(value = "/hi", headers = {"gaojcFeign=true"})
    public String sayHi(@RequestParam String name) {
        return myFeignClient.sayHello(name);
    }
}
