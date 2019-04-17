package com.gaojc.security.jwt;

import com.gaojc.security.service.UserService;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * json web token 过滤器
 *
 * @author gaojc
 * @date 2019/4/15 00:33
 */
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthParameters authParameters;

    @Autowired
    private UserService userService;

    //1.从每个请求header获取token
    //2.调用前面写的validateToken方法对token进行合法性验证
    //3.解析得到username，并从database取出用户相关信息权限
    //4.把用户信息(role等)以UserDetail形式放进SecurityContext以备整个请求过程使用。
    // （例如哪里需要判断用户权限是否足够时可以直接从SecurityContext取出去check）
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = getJwtFromRequest(request);

        if (token != null && jwtTokenProvider.validateToken(token)) {
            String username = getUsernameFromJwt(token, authParameters.getJwtTokenSecret());

            UserDetails userDetails = userService.getUserDetailByUserName(username);

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            logger.error(request.getParameter("username") + " :Token is null");
        }
        super.doFilter(request, response, filterChain);
    }

    /**
     * 从jwt解析出username
     *
     * @param token          jwt
     * @param jwtTokenSecret
     * @return
     * @author gaojc
     * @date 2019/4/15 0:38
     */
    private String getUsernameFromJwt(String token, String jwtTokenSecret) {
        return Jwts.parser().setSigningKey(jwtTokenSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    /**
     * 从http请求header拿到token
     *
     * @param request http请求
     * @return
     * @author gaojc
     * @date 2019/4/15 0:35
     */
    private String getJwtFromRequest(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer")) {
            return token.replace("Bearer ", "");
        }
        return null;
    }
}
