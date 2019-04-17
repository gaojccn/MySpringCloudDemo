package com.gaojc.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 生成以及验证token
 *
 * @author gaojc
 * @date 2019/4/14 23:56
 */
@Component
@Slf4j
public class JwtTokenProvider {
    @Autowired
    private AuthParameters authParameters;

    /**
     * 生成用户登录token
     *
     * @param authentication
     * @return return a token string.
     */
    public String createJwtToken(Authentication authentication) {
        //user name
        String username = ((org.springframework.security.core.userdetails.User)
                authentication.getPrincipal()).getUsername();
        //expire time
        Date expireTime = new Date(System.currentTimeMillis() + authParameters.getTokenExpiredMs());
        //create token
        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(expireTime)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, authParameters.getJwtTokenSecret())
                .compact();
        return token;
    }

    /**
     * <p>
     * 验证token
     * if Jwts can parse the token string and no throw any exception,
     * then the token is eligible.
     * </p>
     *
     * @param token a jws string.
     */
    public boolean validateToken(String token) {
        String VALIDATE_FAILED = "validate failed : ";
        try {
            Jwts.parser()
                    .setSigningKey(authParameters.getJwtTokenSecret())
                    .parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            //ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, //IllegalArgumentException
            log.error(VALIDATE_FAILED + ex.getMessage());
            return false;
        }
    }

}
