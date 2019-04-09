package com.gaojc.serviceprovider.service;

import com.gaojc.serviceprovider.entity.User;
import com.gaojc.serviceprovider.model.UserBO;

public interface UserService {
    User getUser(Integer id);

    void addUser(UserBO user);
}
