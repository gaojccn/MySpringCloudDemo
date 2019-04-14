package com.gaojc.security.controller;

import com.gaojc.security.model.vo.UserVO;
import com.gaojc.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaojc
 * @date 2019/4/13 23:06
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/user")
    @PreAuthorize("hasAuthority('admin')")
    public UserVO loginByUserName(@RequestParam("userName") String userName) {
        return userService.getUserByUserName(userName);
    }

}
