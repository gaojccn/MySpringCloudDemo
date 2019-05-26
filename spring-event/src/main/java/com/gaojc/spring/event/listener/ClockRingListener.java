package com.gaojc.spring.event.listener;

import com.gaojc.spring.event.entity.User;
import com.gaojc.spring.event.event.ClockRingEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * clock ring事件监听器
 * 监听MorningClockEvent 事件
 * 原理是 观察者模式
 *
 * @author gaojc
 * @date 2019/5/26 20:13
 */
@Component
@Slf4j
public class ClockRingListener {

    @EventListener
    public void afterRing(ClockRingEvent clockEvent) {
        //获取注册用户对象
        User user = clockEvent.getUser();
        //输出注册用户信息
        log.info("@EventListener信息，用户：{}，年纪：{}", user.getName(), user.getAge());
        //触发用户行为
        user.doAfterWakeUp();
    }
}
