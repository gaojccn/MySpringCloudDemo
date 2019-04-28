package com.gaojc.consumerFeign.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author gaojc
 * @date 2019/4/28 22:25
 */
@Component
@Data
public class FeignURLProperties {

    @Value("headerPre")
    public String headerPre;

}
