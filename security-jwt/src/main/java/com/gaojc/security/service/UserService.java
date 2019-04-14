package com.gaojc.security.service;

import com.gaojc.security.model.vo.UserVO;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author gaojc
 * @date 2019/4/13 22:19
 */
public interface UserService {

    UserVO getUserByUserName(String userName);

    UserDetails getUserDetailByUserName(String userName);
}