package com.gaojc.spring.event.service;

import com.gaojc.spring.event.event.ClockRingEvent;
import com.gaojc.spring.event.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 闹钟服务，实现注册事件发布功能
 *
 * @author gaojc
 * @date 2019/5/26 20:25
 */
@Service
public class ClockService {

    @Autowired
    ApplicationContext applicationContext;

    /**
     * 用户注册方法
     *
     * @param user
     */
    public void ring(User user) {
        //../省略其他逻辑

        //发布UserRegisterEvent事件
        applicationContext.publishEvent(new ClockRingEvent(this, user));
    }
}
