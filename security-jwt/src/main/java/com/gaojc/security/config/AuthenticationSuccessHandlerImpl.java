package com.gaojc.security.config;

import com.gaojc.security.jwt.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gaojc
 * @date 2019/4/13 22:48
 */
@Service
@Slf4j
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    @Autowired
    private JwtTokenProvider tokenProvider;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {
        log.info("User: " + request.getParameter("username") + " Login successfully.");
        this.returnJson(response, authentication);
    }


    private void returnJson(HttpServletResponse response, Authentication authentication) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
//        response.getWriter().println("{\"exceptionId\":\"null\"," +
//                "\"messageCode\":\"200\"," +
//                "\"message\": \"Login successfully.\"," +
//                "\"serverTime\": " + System.currentTimeMillis() + "}");

        response.getWriter()
                .println("{\"tokenType\":\"Bearer\",\"token\": \"" + tokenProvider.createJwtToken(authentication) + "\"}");


    }
}
