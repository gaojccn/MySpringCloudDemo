package com.gaojc.consumerFeign.common.config;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author gaojc
 * @date 2019/4/28 22:25
 */
@Data
@Component
public class FeignURLProperties implements InitializingBean {

    @Value("headerPre")
    public String headerPre;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(headerPre);
    }
}
