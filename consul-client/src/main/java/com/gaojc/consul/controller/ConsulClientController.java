package com.gaojc.consul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConsulClient 测试 前端控制器
 *
 * @author gaojc
 * @date 2019/4/10 22:55
 */
@RestController
public class ConsulClientController {
    @GetMapping("/info")
    public String info() {
        return "ConsulClientController print info";
    }
}
