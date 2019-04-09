package com.gaojc.serviceprovider.controller;

import com.gaojc.serviceprovider.entity.User;
import com.gaojc.serviceprovider.model.UserBO;
import com.gaojc.serviceprovider.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(value = "用户接口", tags = "用户")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "根据id查询用户", notes = "根据id查询用户")
    @ApiImplicitParam(paramType = "path", name = "id", value = "用户ID",
            example = "1", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public User getUser(@PathVariable(name = "id") Integer id) {
        return userService.getUser(id);
    }

    @ApiOperation(value = "添加用户", notes = "添加用户")
    @PostMapping("/add")
    public void addUser(@RequestBody UserBO userBO) {
        userService.addUser(userBO);
    }

    @ApiOperation(value = "搜索用户", notes = "搜索用户")
    @PostMapping("/query")
    public String userArray(@RequestBody UserBO userBO) {
        return userService.queryUser(userBO);
    }
}
