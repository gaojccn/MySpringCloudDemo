package com.gaojc.admin.server.controller;

import com.gaojc.admin.server.config.ThreadPoolConfig;
import com.gaojc.admin.server.task.MyTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author gaojc
 * @date 2019/5/21 23:04
 */
@RestController
@RequestMapping("/task")
@Slf4j
public class MyTaskController {
    @Resource
    private MyTask myTask;

    @Autowired
    ThreadPoolConfig threadPoolConfig;

    @GetMapping("/run")
    public void runTask() throws Exception {
        log.info("开始执行任务---");

        myTask.doTask1();
        myTask.doTask2();
        myTask.doTask11();
        myTask.doTask21();

        log.info("执行任务结束---");

        threadPoolConfig.check();
//        Thread.currentThread().join();
    }
}
