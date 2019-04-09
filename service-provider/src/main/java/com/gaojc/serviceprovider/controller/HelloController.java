package com.gaojc.serviceprovider.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "helloworld接口", tags = "helloworld")
public class HelloController {

    @Value("${server.port}")
    String port;

    @ApiOperation(value = "hello", notes = "say hello")
    @GetMapping("/hello")
    public String home(@RequestParam(value = "name", defaultValue = "gaojc") String name) {
        return "hello " + name + ",the port is:" + port;
    }

}
