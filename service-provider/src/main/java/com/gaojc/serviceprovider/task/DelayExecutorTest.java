package com.gaojc.serviceprovider.task;

import com.gaojc.serviceprovider.mapper.UserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Component
public class DelayExecutorTest {
    private UserMapper mapper;

    private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor=
            new ScheduledThreadPoolExecutor(5,
                    new ThreadPoolExecutor.CallerRunsPolicy());

    @PostConstruct
    public void init() {

        for (long i = 0; i < 100; i++) {
            scheduledThreadPoolExecutor.schedule(
                    new MyDelayTask(i,"hello gaojc"),
                    i, TimeUnit.SECONDS);
        }

    }
}
