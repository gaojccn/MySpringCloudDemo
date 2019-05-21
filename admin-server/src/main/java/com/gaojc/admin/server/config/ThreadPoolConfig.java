package com.gaojc.admin.server.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author gaojc
 * @date 2019/5/21 22:57
 */
@EnableAsync
@Configuration
@Slf4j
public class ThreadPoolConfig {

    @Bean("taskExecutor1")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(200);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("taskExecutor-1-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return executor;
    }

    @Bean("taskExecutor2")
    public ThreadPoolTaskExecutor taskExecutor2() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(200);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("taskExecutor-2-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return executor;
    }

    public boolean checkStatus() {
        ThreadPoolTaskExecutor executor1 = taskExecutor();
        int activeCount = executor1.getThreadPoolExecutor().getActiveCount();
        boolean terminated = executor1.getThreadPoolExecutor().isTerminated();

        log.info("taskExecutor1 activeCount={},terminated={}", activeCount, terminated);
        if (activeCount == 0) {
            executor1.shutdown();
        }

        ThreadPoolTaskExecutor executor2 = taskExecutor2();
        int activeCount2 = executor2.getThreadPoolExecutor().getActiveCount();
        boolean terminated2 = executor2.getThreadPoolExecutor().isTerminated();

        log.info("taskExecutor2 activeCount={},terminated={}", activeCount2, terminated2);
        if (activeCount2 == 0) {
            executor2.shutdown();
        }
        return terminated && terminated2;
    }

    public void check() throws InterruptedException {
        while (true) {
            boolean shutDown = checkStatus();
            if (shutDown) {
                break;
            }
            Thread.sleep(2000);
        }
    }
}
