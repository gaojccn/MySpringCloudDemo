package com.gaojc.stream.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.SubscribableChannel;

/**
 * 消息 消费者
 *
 * @author gaojc
 * @date 2019/4/24 00:18
 */
@EnableBinding(SampleSink.MultiInputSink.class)
public class SampleSink {

    @StreamListener(MultiInputSink.INPUT1)
    public synchronized void receive1(String message) {
        System.out.println("******************");
        System.out.println("At Sink1");
        System.out.println("******************");
        System.out.println("Received message " + message);
    }

    @StreamListener(MultiInputSink.INPUT2)
    public synchronized void receive2(String message) {
        System.out.println("******************");
        System.out.println("At Sink2");
        System.out.println("******************");
        System.out.println("Received message " + message);
    }

    public interface MultiInputSink {
        String INPUT1 = "input1";

        String INPUT2 = "input2";

        @Input(INPUT1)
        SubscribableChannel input1();

        @Input(INPUT2)
        SubscribableChannel input2();
    }
}
