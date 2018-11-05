package com.gaojc.rabbitmq;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RabbitMqServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RabbitMqServerApplication.class)
                .web(true)
                .run(args);
    }
}
