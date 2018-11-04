package com.gaojc.serviceprovider.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User implements Serializable {
    @TableId
    private Integer id;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "pass_word")
    private String passWord;

    @TableField(value = "email")
    private String email;

}
