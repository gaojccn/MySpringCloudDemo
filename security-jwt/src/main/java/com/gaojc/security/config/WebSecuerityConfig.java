package com.gaojc.security.config;

import com.gaojc.security.jwt.JwtAuthenticationFilter;
import com.gaojc.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author gaojc
 * @date 2019/4/13 22:37
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecuerityConfig {

    @Configuration
    public static class MySecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        @Qualifier("myUserDetailsServiceImpl")
        private MyUserDetailsService myUserDetailsService;

        @Autowired
        @Qualifier("authenticationSuccessHandlerImpl")
        private AuthenticationSuccessHandler successHandler;

        @Autowired
        @Qualifier("authenticationFailureHandlerImpl")
        private AuthenticationFailureHandler failHandler;

        @Autowired
        @Qualifier("authenticationEntryPointImpl")
        private AuthenticationEntryPoint entryPoint;

        @Override
        public void configure(AuthenticationManagerBuilder builder) throws Exception {
            builder.userDetailsService(myUserDetailsService);
        }

        @Bean
        public JwtAuthenticationFilter getJwtAuthenticationFilter() {
            return new JwtAuthenticationFilter();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.addFilterBefore(getJwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class).
                    sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and().csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/v2/api-docs/**").permitAll()
                    .anyRequest().authenticated()
                    .and().formLogin().loginProcessingUrl("/api/login")
                    .successHandler(successHandler)
                    .failureHandler(failHandler)
                    .and().exceptionHandling().authenticationEntryPoint(entryPoint);

        }
    }
}
