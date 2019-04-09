package com.gaojc.rabbitmq.mq;

import com.gaojc.rabbitmq.config.RabbitMqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * mq消息生产者
 *
 * @author gaojc
 * @date 2019/4/9 22:01
 */
@Component
@Slf4j
public class MqProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送2条消息到2个队列
     *
     * @param
     * @return
     * @author gaojc
     * @date 2019/4/9 22:01
     */
    public void sendMqMsg() {
        String msg1 = "this is mq msg 1";
        String msg2 = "this is mq msg 2";
        log.info("send mq msgs: {},{}", msg1, msg2);
        this.amqpTemplate.convertAndSend(RabbitMqConfig.QUEUE_NAME, msg1);
        this.amqpTemplate.convertAndSend(RabbitMqConfig.QUEUE_NAME_SECOND, msg2);
    }
}
