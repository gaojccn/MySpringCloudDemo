package com.gaojc.rabbitmq.mq;

import com.gaojc.rabbitmq.config.RabbitMqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
/**
 * 消息消费者，接收到2个队列的消息
 */
public class MqConsumer {

    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME)
    @RabbitHandler
    public void handleMsg(String message) {
        log.info("1 received mq msg: {}", message);
    }

    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME_SECOND)
    @RabbitHandler
    public void handleMsg2(String message) {
        log.info("2 received mq msg: {}", message);
    }
}

