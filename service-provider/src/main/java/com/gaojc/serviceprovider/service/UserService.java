package com.gaojc.serviceprovider.service;

import com.gaojc.serviceprovider.entity.User;
import com.gaojc.serviceprovider.model.UserBO;

/**
 * @author gaojc
 */
public interface UserService {
    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return 用户
     * @author gaojc
     * @since 2019/4/9 17:26
     */
    User getUser(Integer id);

    /**
     * 添加用户
     *
     * @param userBO user请求对象
     * @return void
     * @author gaojc
     * @since 2019/4/9 17:27
     */
    void addUser(UserBO userBO);

    /**
     * 查询用户
     *
     * @param userBO user查询对象
     * @return User对象toString字符串
     * @author gaojc
     * @since 2019/4/9 17:27
     */
    String queryUser(UserBO userBO);
}
