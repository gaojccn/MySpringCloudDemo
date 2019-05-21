package com.gaojc.admin.server.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 线程任务
 *
 * @author gaojc
 * @date 2019/5/21 23:00
 */
@Slf4j
@Component
public class MyTask {
    public static Random random = new Random();

    @Async("taskExecutor1")
    public void doTask1() throws Exception {
        log.info("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务一，耗时：" + (end - start) + "毫秒");
    }

    @Async("taskExecutor2")
    public void doTask2() throws Exception {
        log.info("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务二，耗时：" + (end - start) + "毫秒");
    }

    @Async("taskExecutor1")
    public void doTask11() throws Exception {
        log.info("开始做任务11");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务11，耗时：" + (end - start) + "毫秒");
    }

    @Async("taskExecutor2")
    public void doTask21() throws Exception {
        log.info("开始做任务21");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务21，耗时：" + (end - start) + "毫秒");
    }
}
