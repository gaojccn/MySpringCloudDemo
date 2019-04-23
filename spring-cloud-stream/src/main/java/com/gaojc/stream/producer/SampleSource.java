package com.gaojc.stream.producer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

/**
 * 消息生产者
 *
 * @author gaojc
 * @date 2019/4/24 00:07
 */
@EnableBinding(SampleSource.MultiOutputSource.class)
public class SampleSource {

    //自定义发送通道
    public interface MultiOutputSource {
        String OUTPUT1 = "output1";

        String OUTPUT2 = "output2";

        @Output(OUTPUT1)
        MessageChannel output1();

        @Output(OUTPUT2)
        MessageChannel output2();
    }

    @Bean
    @InboundChannelAdapter(value = MultiOutputSource.OUTPUT1,
            poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "1"))
    public synchronized MessageSource<String> messageSource1() {
        return () -> {
            String message = "FromSource1";
            System.out.println("******************");
            System.out.println("From Source1");
            System.out.println("******************");
            System.out.println("Sending value: " + message);
            return new GenericMessage(message);
        };
    }

    @Bean
    @InboundChannelAdapter(value = MultiOutputSource.OUTPUT2,
            poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "1"))
    public synchronized MessageSource<String> timerMessageSource() {
        return () -> {
            String message = "FromSource2";
            System.out.println("******************");
            System.out.println("From Source2");
            System.out.println("******************");
            System.out.println("Sending value: " + message);
            return new GenericMessage(message);
        };
    }
}
