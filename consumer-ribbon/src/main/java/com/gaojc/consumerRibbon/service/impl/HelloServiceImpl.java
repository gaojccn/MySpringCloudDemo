package com.gaojc.consumerRibbon.service.impl;

import com.alibaba.fastjson.JSON;
import com.gaojc.consumerRibbon.dto.UserDto;
import com.gaojc.consumerRibbon.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class HelloServiceImpl implements HelloService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "errorHandle")
    public String sayHi(String name) {
        return restTemplate.getForObject("http://SERVICE-PROVIDER/hello?name=" + name, String.class);
    }

    @Override
    public String getUsers() {
        String jsonStr = restTemplate.getForObject("http://service-provider/users", String.class);
        log.info("jsonStr = {}", jsonStr);
        List<UserDto> userDtos = JSON.parseArray(jsonStr, UserDto.class);
        log.info("userDtos = {}", userDtos);
        System.out.println(userDtos);
        return userDtos.toString();
    }

    /**
     * 错误处理方法
     *
     * @param name
     * @return
     */
    public String errorHandle(String name) {
        return "this is errorHandle," + name;
    }

    public String errorHandle2() {
        return "this is errorHandle";
    }
}
