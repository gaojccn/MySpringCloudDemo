package com.gaojc.zipkin.service.a.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * zipkin 服务跟踪测试
 * @author gaojc
 * @date 2019/4/9 22:55
 */
@RequestMapping("/srvb")
@RestController
@Slf4j
public class ZipkinController {
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/hi")
    public String hi(){
        log.info("zipkin service b hi()");
        return restTemplate.getForObject("http://localhost:8898/srva/info", String.class);
    }

    @GetMapping("/info")
    public String info(){
        log.info("zipkin service b info()");
        return "srvb info()";
    }
}
