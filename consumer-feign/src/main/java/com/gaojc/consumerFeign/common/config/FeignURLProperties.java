package com.gaojc.consumerFeign.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gaojc
 * @date 2019/4/28 22:25
 */
@Component
@Data
@ConfigurationProperties
public class FeignURLProperties {
    public String headerPre;

}
