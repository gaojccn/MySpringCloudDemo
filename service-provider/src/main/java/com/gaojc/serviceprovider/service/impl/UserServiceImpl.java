package com.gaojc.serviceprovider.service.impl;

import com.gaojc.serviceprovider.entity.User;
import com.gaojc.serviceprovider.mapper.UserMapper;
import com.gaojc.serviceprovider.model.UserBO;
import com.gaojc.serviceprovider.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
    public void addUser(UserBO userBO) {
        User user = new User();
        BeanUtils.copyProperties(userBO, user);
        int count = userMapper.insert(user);
        if (count > 0) {
            log.info("insert success a user :{}", user);
        }
    }
}
