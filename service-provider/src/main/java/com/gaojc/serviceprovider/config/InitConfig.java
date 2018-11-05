package com.gaojc.serviceprovider.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.gaojc.serviceprovider.mapper*")
@Configuration
public class InitConfig {
}