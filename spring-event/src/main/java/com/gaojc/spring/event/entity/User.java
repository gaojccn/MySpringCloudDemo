package com.gaojc.spring.event.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户
 *
 * @author gaojc
 * @date 2019/5/26 20:21
 */
@Data
@Slf4j
public class User {
    //名字
    private String name;

    //年纪
    private Integer age;

    /**
     * 早上起床后 做的事情
     *
     * @author gaojc
     * @date 2019/5/26 20:39
     */
    public void doAfterWakeUp() {
        log.info("{} 刷牙洗脸", name);
        log.info("{} 吃早餐", name);
        log.info("{} 出门干活", name);
    }
}
