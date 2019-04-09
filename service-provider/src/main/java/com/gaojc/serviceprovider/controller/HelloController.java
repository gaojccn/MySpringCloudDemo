package com.gaojc.serviceprovider.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.gaojc.serviceprovider.entity.User;
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

    @ApiOperation(value = "hello",notes = "say hello")
    @GetMapping("/hello")
    public String home(@RequestParam(value = "name", defaultValue = "gaojc") String name) {
        return "hello " + name + ",the port is:" + port;
    }

    @ApiOperation(value = "",notes = "查询用户")
    @GetMapping("/users")
    public String userArray() {
        JSONArray jsonArray = new JSONArray();
        User user1 = new User(1, "gaojc", "man", "dd@126.cm");
        User user2 = new User(2, "menghe", "man", "dop@163.cm");

        jsonArray.add(JSON.toJSON(user1));
        jsonArray.add(JSON.toJSON(user2));
        return jsonArray.toJSONString();
    }
}
