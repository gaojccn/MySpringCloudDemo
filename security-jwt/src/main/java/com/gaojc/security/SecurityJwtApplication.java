package com.gaojc.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gaojc
 * @date 2019/4/13 23:20
 */
@SpringBootApplication
@MapperScan("com.gaojc.security.mapper")
public class SecurityJwtApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityJwtApplication.class, args);
    }

}
