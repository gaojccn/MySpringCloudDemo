package com.gaojc.consumerFeign.controller;

import com.gaojc.consumerFeign.common.config.FeignURLProperties;
import com.gaojc.consumerFeign.service.MyFeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/csmf")
public class FeignController {
    @Autowired
    private MyFeignClientService myFeignClientService;

    @GetMapping(value = "/hi", headers = {"headerPre=true"})
    public String sayHi(@RequestParam String name) {
        return myFeignClientService.sayHello(name);
    }
}
