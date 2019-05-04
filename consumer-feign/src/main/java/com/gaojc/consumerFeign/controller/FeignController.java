package com.gaojc.consumerFeign.controller;

import com.gaojc.consumerFeign.client.MyFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/csmf")
public class FeignController {
    @Autowired
    private MyFeignClient myFeignClient;

    @GetMapping(value = "/hi", headers = {"gaojcFeign=true"})
    public String sayHi(@RequestParam String name) {
        return myFeignClient.sayHello(name);
    }
}
