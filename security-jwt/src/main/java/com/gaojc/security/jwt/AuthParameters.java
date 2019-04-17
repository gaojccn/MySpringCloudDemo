package com.gaojc.security.jwt;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author gaojc
 * @date 2019/4/15 00:25
 */
@Component
@Data
public class AuthParameters {

    @Value("${jwtTokenSecret}")
    private String jwtTokenSecret;

    @Value("${tokenExpiredMs}")
    private long tokenExpiredMs;

}
