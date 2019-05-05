package com.gaojc.consumerFeign.service.impl;

import com.gaojc.consumerFeign.client.MyFeignClient;
import com.gaojc.consumerFeign.service.MyFeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gaojc
 * @date 2019/5/5 22:06
 */
@Service
public class MyFeignClientServiceImpl implements MyFeignClientService {
    @Autowired
    private MyFeignClient myFeignClient;

    @Override
    public String sayHello(String name) {
        return myFeignClient.sayHello(name);
    }
}
