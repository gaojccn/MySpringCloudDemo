package com.gaojc.serviceprovider.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.gaojc.serviceprovider.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${server.port}")
    String port;

    @GetMapping("/hello")
    public String home(@RequestParam(value = "name", defaultValue = "gaojc") String name) {
        return "hello " + name + ",the port is:" + port;
    }

    @GetMapping("/users")
    public String userArray() {
        JSONArray jsonArray = new JSONArray();
        User user1 = new User(1,"gaojc", "man", "dd@126.cm");
        User user2 = new User(2,"menghe", "man", "dop@163.cm");

        jsonArray.add(JSON.toJSON(user1));
        jsonArray.add(JSON.toJSON(user2));
        return jsonArray.toJSONString();
    }
}
