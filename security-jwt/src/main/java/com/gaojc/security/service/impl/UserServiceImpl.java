package com.gaojc.security.service.impl;

import com.gaojc.security.entity.User;
import com.gaojc.security.mapper.UserMapper;
import com.gaojc.security.model.vo.UserVO;
import com.gaojc.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gaojc
 * @date 2019/4/13 22:21
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails getUserDetailByUserName(String userName) {
        User user = userMapper.findByUserName(userName);
        if (user == null) {
            //throw exception inform front end not this user
            throw new UsernameNotFoundException("user + " + userName + "not found.");
        }
        List<String> roleCodeList = userMapper.queryUserOwnedRoleNames(userName);

        List<GrantedAuthority> authorities =
                roleCodeList.stream().map(e -> new SimpleGrantedAuthority(e)).collect(Collectors.toList());

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUserName(), user.getPassWord(), authorities);

        return userDetails;
    }

    @Override
    public UserVO getUserByUserName(String userName) {
        UserVO userVO = new UserVO();
        User user = userMapper.findByUserName(userName);
        userVO.setUserName(user.getUserName());
        userVO.setUserDesc(user.getUserDesc());

        List<String> userRoles = userMapper.queryUserOwnedRoleNames(userName);
        userVO.setRoleNames(userRoles);
        return userVO;
    }

}
