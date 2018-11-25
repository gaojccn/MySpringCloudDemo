package com.gaojc.serviceprovider.service.impl;

import com.gaojc.serviceprovider.entity.User;
import com.gaojc.serviceprovider.mapper.UserMapper;
import com.gaojc.serviceprovider.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Integer id) {
        log.info("getUser by id = {}", id);
        return userMapper.selectById(id);
    }

    @Override
    public void addUser(User user) {
        int save = userMapper.insert(user);
        log.info("insert success {} user", save);
    }
}
