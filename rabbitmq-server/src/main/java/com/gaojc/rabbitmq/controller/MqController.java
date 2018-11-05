package com.gaojc.rabbitmq.controller;

import com.gaojc.rabbitmq.mq.MqProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/mq")
public class MqController {
    @Autowired
    private MqProducer mqProducer;

    @GetMapping("/send")
    public void sendMq() {
        mqProducer.sendMqMsg();
    }
}
