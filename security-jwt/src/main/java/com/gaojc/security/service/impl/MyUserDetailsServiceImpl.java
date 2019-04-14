package com.gaojc.security.service.impl;

import com.gaojc.security.service.MyUserDetailsService;
import com.gaojc.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @author gaojc
 * @date 2019/4/14 00:03
 */
@Service
public class MyUserDetailsServiceImpl implements MyUserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        return this.userService.getUserDetailByUserName(userName);
    }

}
