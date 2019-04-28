package com.gaojc.consumerFeign.common.config;

import feign.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaojc
 * @date 2019/4/28 22:32
 */
@Configuration
public class MyFeignAutoConfiguration {

    @Bean
    public Client feignClient(CachingSpringLoadBalancerFactory cachingFactory,
                              SpringClientFactory clientFactory,
                              @Autowired(required = false)
                                      DiscoveryClient discoveryClient) {
        return new MyLoadBalancerFeignClient(new Client.Default(null,
                null),
                cachingFactory, clientFactory, discoveryClient);
    }

}
