package com.gaojc.security.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author gaojc
 * @date 2019/4/13 22:07
 */
@Data
@TableName("sys_user_role")
public class UserRole implements Serializable {
    @TableId
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    @TableField("role_code")
    private String roleCode;

    @TableField("role_name")
    private String roleName;
}
