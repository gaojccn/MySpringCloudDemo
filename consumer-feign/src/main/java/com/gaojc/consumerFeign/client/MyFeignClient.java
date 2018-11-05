package com.gaojc.consumerFeign.client;

import com.gaojc.consumerFeign.client.impl.MyFeignClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-provider", fallback = MyFeignClientHystrix.class)
public interface MyFeignClient {
    /**
     * 调用service-provider服务的/hello接口
     *
     * @param name
     * @return
     */
    @GetMapping(value = "/hello")
    String sayHello(@RequestParam(value = "name") String name);
}
