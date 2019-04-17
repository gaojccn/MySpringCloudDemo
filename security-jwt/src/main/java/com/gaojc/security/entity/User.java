package com.gaojc.security.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author gaojc
 * @date 2019/4/13 21:54
 */
@Data
@TableName("sys_user")
public class User implements Serializable {
    private static final long serialVersionUID = 9159764594799290034L;

    @TableId
    private Integer id;

    @TableField("user_name")
    private String userName;

    @TableField("pass_word")
    private String passWord;

    @TableField("user_desc")
    private String userDesc;

}
