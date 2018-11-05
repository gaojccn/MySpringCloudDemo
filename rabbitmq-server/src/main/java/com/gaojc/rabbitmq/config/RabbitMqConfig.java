package com.gaojc.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class RabbitMqConfig {
    //2个消息队列
    public static final String QUEUE_NAME = "QUEUE_ONE";
    public static final String QUEUE_NAME_SECOND = "QUEUE_TWO";

    @Bean
    public List<Queue> rabbitMqQueue() {
        List<Queue> queues = new ArrayList<>();
        queues.add(new Queue(QUEUE_NAME));
        queues.add(new Queue(QUEUE_NAME_SECOND));
        return queues;
    }
}
