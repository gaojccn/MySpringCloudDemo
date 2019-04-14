package com.gaojc.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gaojc.security.entity.User;

import java.util.List;

/**
 * @author gaojc
 * @date 2019/4/13 22:14
 */
public interface UserMapper extends BaseMapper<User> {

    User findByUserName(String userName);

    List<String> queryUserOwnedRoleCodes(String userName);
}
