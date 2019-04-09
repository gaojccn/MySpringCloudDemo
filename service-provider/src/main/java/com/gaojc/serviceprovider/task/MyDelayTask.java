package com.gaojc.serviceprovider.task;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyDelayTask implements Runnable {
    private Long delayTime;
    private String msg;

    public MyDelayTask(Long delayTime, String msg) {
        this.delayTime = delayTime;
        this.msg = msg;
    }

    @Override
    public void run() {
        log.info("delay print count={} msg={}", delayTime, msg);
    }
}
