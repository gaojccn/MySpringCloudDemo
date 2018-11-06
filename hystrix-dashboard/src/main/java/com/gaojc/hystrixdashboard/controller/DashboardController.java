package com.gaojc.hystrixdashboard.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DashboardController {

    @GetMapping("/board")
    public void dashboard(){
        log.info("here is the dashboard");
    }
}
