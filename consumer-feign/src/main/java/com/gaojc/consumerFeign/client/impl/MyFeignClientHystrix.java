package com.gaojc.consumerFeign.client.impl;

import com.gaojc.consumerFeign.client.MyFeignClient;
import org.springframework.stereotype.Component;

/**
 * 熔断处理类
 */
@Component
public class MyFeignClientHystrix implements MyFeignClient {
    @Override
    public String sayHello(String name) {
        return "this is hystrix handle," + name;
    }
}
