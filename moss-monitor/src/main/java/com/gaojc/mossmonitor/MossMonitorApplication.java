package com.gaojc.mossmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author gaojc
 * @date 2019/5/7 22:39
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MossMonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(MossMonitorApplication.class, args);
    }
}
