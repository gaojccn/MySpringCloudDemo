package com.gaojc.spring.event.event;

import com.gaojc.spring.event.entity.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * 闹钟响铃事件
 *
 * @author gaojc
 * @date 2019/5/26 20:12
 */
@Getter
public class ClockRingEvent extends ApplicationEvent {
    /**
     * 早晨闹钟响，通知用户doSth
     *
     * @author gaojc
     * @date 2019/5/26 20:22
     */
    private User user;

    public ClockRingEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
