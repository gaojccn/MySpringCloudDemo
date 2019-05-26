package com.gaojc.spring.event.controller;

import com.gaojc.spring.event.entity.User;
import com.gaojc.spring.event.service.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaojc
 * @date 2019/5/26 20:28
 */
@RestController
@RequestMapping("/clock")
public class ClockController {
    //用户业务逻辑实现
    @Autowired
    private ClockService userService;

    /**
     * 闹铃 ring方法
     *
     * @param user 用户对象
     * @return
     */
    @RequestMapping(value = "/ring")
    public String register(@RequestBody User user) {
        //调用ring业务逻辑
        userService.ring(user);
        return "闹钟响了[ring...]";
    }
}
